package cn.xingyu.myfine.controller;


import cn.xingyu.myfine.pojo.Classify;
import cn.xingyu.myfine.pojo.Product;
import cn.xingyu.myfine.service.ClassifyService;
import cn.xingyu.myfine.service.ProductService;
import cn.xingyu.myfine.util.Data;
import cn.xingyu.myfine.util.JsonUtils;
import cn.xingyu.myfine.util.UploadFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.RandomUtils;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    /**
     * 注入productService
     */
    @Resource(name = "proService")
    private ProductService productService;
    /**
     * 注入ClassifyService
     */
    @Resource(name = "classService")
    private ClassifyService classifyService;

    private UploadFile uploadFile = new UploadFile();

    /**
     * 日志输出
     */
    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    /**
     * 获得最新的五条商品信息
     *
     * @return json
     */
    @RequestMapping("/getNewProductFive.html")
    @ResponseBody
    public Object getNewProductFive() {
        List<Product> list = productService.getNewProduct();
        //输出json信息
        logger.info(JsonUtils.objectToJson(list));
        return JsonUtils.objectToJson(list);
    }

    /**
     * 获取除了前五条最新上架的商品信息
     *
     * @return json
     */
    @RequestMapping("/getNewProductNotFive.html")
    @ResponseBody
    public Object getNewProductNotFive() {
        List<Product> list = productService.getProductNotFive();
        //输出json信息
        logger.info(JsonUtils.objectToJson(list));
        return JsonUtils.objectToJson(list);
    }

    /**
     * 获取商品信息 根据购买次数排列
     *
     * @return json
     */
    @RequestMapping("/getProductByBuyCounts.html")
    @ResponseBody
    public Object getProductByBuyCounts() {
        List<Product> list = productService.getProductByBuyCounts();
        //输出json信息
        logger.info(JsonUtils.objectToJson(list));
        return JsonUtils.objectToJson(list);
    }

    /**
     * 根据商品id获取商品信息
     *
     * @param id 商品id
     * @return json
     */
    @RequestMapping("/getProductById.html")
    @ResponseBody
    public Object getProductById(String id) {
        Product product = productService.getProductById(id);
        //输出json信息
        logger.info(JsonUtils.objectToJson(product));
        return JsonUtils.objectToJson(product);
    }

    /**
     * 获取商品所有信息的集合
     *
     * @param index 当前页
     * @param model 模型
     * @return 逻辑字符串
     */
    @RequestMapping("/getProductAll.html")
    public String getProductAll(@RequestParam(value = "pageIndex", defaultValue = "1") Integer index, Model model) {
        //开始分页 声明分页信息（当前页，每页记录数）
        //查询之前传入 当前页 和页面容量
        PageHelper.startPage(index, 10);
        //获取商品集合
        List<Product> list = productService.getProductList();
        //查询调用方法对查询结果进行包装成PageInfo对象
        PageInfo pageInfo = new PageInfo<Product>(list);
        //获取分类集合
        List<Classify> classifyList = classifyService.getClassifyList();
        //塞进model
        model.addAttribute("classifyList", classifyList);
        model.addAttribute("page", pageInfo);
        return "productList";
    }

    /**
     * 跳转至新增商品页面
     *
     * @return 逻辑字符串
     */
    @RequestMapping("/toAddProduct.html")
    public String toAddProduct(Product product, Model model) {
        //hh获取分类集合
        List<Classify> list = classifyService.getClassifyList();
        model.addAttribute("classifyList", list);
        model.addAttribute("product", product);
        return "addProduct";
    }

    /**
     * 新增商品
     *
     * @param product 商品对象
     * @param file    文件对象
     * @return 逻辑字符
     */
    @RequestMapping("/addProduct.html")
    public Object addProduct(Product product, @RequestParam("file") MultipartFile file) {
        Data data = uploadFile.upload(file);
        boolean flag = false;
        if (data.getResult().equals("success")) {
            product.setFileAddress(data.getMessage());
            flag = productService.persistenceProduct(product);
            if (flag) {
                return "redirect:/product/getProductAll.html";
            }
        }
        return "redirect:/product/toAddProduct.html";
    }

    /**
     * 去修改 根据商品id到修改页面
     *
     * @param id 商品id
     * @return 商品对象的json串
     */
    @RequestMapping("/toUpdateProduct.html")
    public String toUpdate(String id, Model model) {
        //获取需要修改的对象
        Product product = productService.getProductById(id);
        List<Classify> list = classifyService.getClassifyList();
        model.addAttribute("classifyList", list);
        model.addAttribute("product", product);
        return "updateProduct";
    }

    /**
     * 修改商品为删除状态
     *
     * @param id 商品id
     * @return json
     */
    @RequestMapping("/delPro.html")
    @ResponseBody
    public Object delPro(String id) {
        Data data = new Data();
        //调用方法
        boolean flag = productService.delPro(id);
        if (flag) {
            data.setResult("success");
            data.setMessage("变更成功！");
        } else {
            data.setResult("failed");
            data.setMessage("变更失败！");
        }
        return JsonUtils.objectToJson(data);
    }

    /**
     * 修改商品为上架
     *
     * @param id 商品id
     * @return json
     */
    @RequestMapping("/upPro.html")
    @ResponseBody
    public Object upPro(String id) {
        Data data = new Data();
        //调用方法
        boolean flag = productService.upPro(id);
        if (flag) {
            data.setResult("success");
            data.setMessage("上架成功！");
        } else {
            data.setResult("failed");
            data.setMessage("上架失败！");
        }
        return JsonUtils.objectToJson(data);
    }

    /**
     * 根据二级分类id获取商品集合
     *
     * @param level2Id 二级分类id
     * @return json
     */
    @RequestMapping("/getProByLevel2Id.html")
    @ResponseBody
    public Object getProByLevel2Id(String level2Id) {
        List<Product> list = productService.getProListByLevel2Id(level2Id);
        return JsonUtils.objectToJson(list);
    }

}

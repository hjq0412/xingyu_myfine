package cn.xingyu.myfine.controller;


import cn.xingyu.myfine.pojo.Classify;
import cn.xingyu.myfine.pojo.Product;
import cn.xingyu.myfine.service.ClassifyService;
import cn.xingyu.myfine.service.ProductService;
import cn.xingyu.myfine.util.JsonUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    /**
     * 注入productService
     */
    @Resource(name = "proService")
    private ProductService productService;
    @Autowired
    private ClassifyService classifyService;

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
    public Object getProductById(String id) {
        Product product = productService.getProductById(id);
        //输出json信息
        logger.info(JsonUtils.objectToJson(product));
        return JsonUtils.objectToJson(product);
    }

    /**
     * 获取商品所有信息的集合
     * @param index 当前页
     * @param model 模型
     * @return 逻辑字符串
     */
    @RequestMapping("/getProductAll.html")
    public String getProductAll(@RequestParam(value = "index", defaultValue = "1") Integer index, Model model) {
        //开始分页 声明分页信息（当前页，每页记录数）
        //查询之前传入 当前页 和页面容量
        PageHelper.startPage(index, 10);
        //获取商品集合
        List<Product> list = productService.getProductList();
        //查询调用方法对查询结果进行包装成PageInfo对象
        PageInfo pageInfo = new PageInfo<>(list);
        //获取分类集合
        List<Classify> classifyList=classifyService.getClassifyList();
        //塞进model
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("classifyList",classifyList);
        return "productList";
    }
}

package cn.xingyu.myfine.controller;


import cn.xingyu.myfine.pojo.Classify;
import cn.xingyu.myfine.service.ClassifyService;
import cn.xingyu.myfine.util.Data;
import cn.xingyu.myfine.util.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * 分类Controller
 *
 * @author You
 * @since 2019-01-08
 */
@Controller
@RequestMapping("/classify")
public class ClassifyController {
    /**
     * 注入ClassifyService
     */
    @Resource(name = "classService")
    private ClassifyService classifyService;

    /**
     * 获取分类集合
     *
     * @param model 模型
     * @return 逻辑字符串
     */
    @RequestMapping("/classifyList.html")
    public String getClassifyList(@RequestParam(value = "pageIndex", defaultValue = "1") Integer index, Model model) {
        PageHelper.startPage(index, 10);
        //获取分类集合
        List<Classify> list = classifyService.getClassifyList();
        //查询调用方法对查询结果进行包装成PageInfo对象
        PageInfo pageInfo = new PageInfo<Classify>(list, index);
        List<Classify> classifyList = classifyService.getClassifyList();
        //放入model
        model.addAttribute("page", pageInfo);
        model.addAttribute("classifyList", classifyList);
        return "classifyList";
    }

    /**
     * 去修改页面
     *
     * @param id 分类id
     * @return 逻辑字符串 修改分类页面
     */
    @RequestMapping("/toUpdate.html")
    public String getClassifyById(String id, Model model) {
        //根据id获取分类
        Classify classify = classifyService.getClassifyById(id);
        //分类集合
        List<Classify> classifyList = classifyService.getClassifyList();
        model.addAttribute("classifyList", classifyList);
        model.addAttribute("classify", classify);
        return "updateClassify";
    }

    /**
     * 修改分类信息
     *
     * @param formUpdate 传来的表单json
     * @return json
     */
    @RequestMapping("/updateClassify.html")
    @ResponseBody
    public Object updateClassify(String formUpdate) {
        Data data = new Data();
        //将表单的json转化为具体对应的实体类
        Classify classify = JsonUtils.jsonToPojo(formUpdate, Classify.class);
        //调用修改
        boolean flag = classifyService.updateClassify(classify);
        if (flag) {
            data.setResult("success");
            data.setMessage("修改成功！");
        } else {
            data.setResult("failed");
            data.setMessage("修改失败！");
        }
        //返回 将保存json结果的对象转换为json对象
        return JsonUtils.objectToJson(data);
    }

    /**
     * 删除分类
     *
     * @param id 分类id
     * @return json
     */
    @RequestMapping("/delClassify.html")
    @ResponseBody
    public Object delClassify(String id, String type) {
        Data data = new Data();
        //调用方法
        boolean flag = classifyService.delClassify(id, type);
        if (flag) {
            data.setResult("success");
            data.setMessage("删除成功！");
        } else {
            data.setResult("failed");
            data.setMessage("此分类下有商品不能删除！");
        }
        return JsonUtils.objectToJson(data);
    }

    /**
     * 新增分类
     *
     * @param formAdd 分类的json对象
     * @return json
     */
    @RequestMapping("addClassify.html")
    @ResponseBody
    public Object addclassify(String formAdd) {
        Data data = new Data();
        //将表单json转化为具体的类
        Classify classify = JsonUtils.jsonToPojo(formAdd, Classify.class);
        //调用新增方法
        boolean flag = classifyService.addClassify(classify);
        //tru为新增成功
        if (flag) {
            data.setResult("success");
            data.setMessage("新增成功！");
        } else {
            data.setResult("failed");
            data.setMessage("新增失败！");
        }
        //返回 将保存json结果的对象转换为json对象
        return JsonUtils.objectToJson(data);

    }

    /**
     * 一级分类下拉框改变事件
     * 根据一级分类获取二级分类名称id
     *
     * @param level1Id 一级分类id
     * @return jsonList
     */
    @RequestMapping("/level1IdChange.html")
    @ResponseBody
    public Object level1IdChange(String level1Id) {
        List<Classify> list = classifyService.getLevel1IdChilren(level1Id);
        return JsonUtils.objectToJson(list);
    }


    /**
     * 获取一级分类名称id
     * @return json
     */
    @RequestMapping("/getLevel1.html")
    @ResponseBody
    public Object getLevel1(){
        List<Classify> list = classifyService.getLevel1();
        return JsonUtils.objectToJson(list);
    }
}

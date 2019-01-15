package cn.xingyu.myfine.controller;


import cn.xingyu.myfine.pojo.Classify;
import cn.xingyu.myfine.service.ClassifyService;
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
 *  前端控制器
 * </p>
 *  分类Controller
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
     * @param model 模型
     * @return 逻辑字符串
     */
    @RequestMapping("/classifyList.html")
    public String getClassifyList(@RequestParam(value = "pageIndex", defaultValue = "1") Integer index, Model model){
        PageHelper.startPage(index,10);
        //获取分类集合
        List<Classify> list= classifyService.getClassifyList();
        //查询调用方法对查询结果进行包装成PageInfo对象
        PageInfo pageInfo = new PageInfo<Classify>(list,index);
        //放入model
        model.addAttribute("page",pageInfo);
        return "classifyList";
    }

    /**
     * 去修改页面
     * @param id
     * @return
     */
    @RequestMapping("/toUpdate.html")
    public String getClassifyById(String id,Model model){
      Classify classify=classifyService.getClassifyById(id);
      List<Classify> classifyList=classifyService.getClassifyList();
      model.addAttribute("classifyList",classifyList);
      model.addAttribute("classify",classify);
      return "updateClassify";
    }



}

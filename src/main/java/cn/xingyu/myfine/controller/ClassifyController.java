package cn.xingyu.myfine.controller;


import cn.xingyu.myfine.pojo.Classify;
import cn.xingyu.myfine.service.ClassifyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String getClassifyList(@RequestParam(value = "index", defaultValue = "1") Integer index, Model model){
        //开始分页 声明分页信息（当前页，每页记录数）
        //查询之前传入 当前页 和页面容量
        PageHelper.startPage(index, 8);
        //获取分类集合
        List<Classify> list =classifyService.getClassifyList();
        PageInfo pageInfo=new PageInfo<>(list);
        //放入model
        model.addAttribute("pageInfo",pageInfo);
        return "classifyList";
    }

}

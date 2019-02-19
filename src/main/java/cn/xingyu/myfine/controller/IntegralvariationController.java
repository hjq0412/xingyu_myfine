package cn.xingyu.myfine.controller;


import cn.xingyu.myfine.pojo.Integralvariation;
import cn.xingyu.myfine.service.IntegralvariationService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
@Controller
@RequestMapping("/integralvariation")
public class IntegralvariationController {

    /**
     * 注入service
     */
    @Resource(name = "integralvarService")
    private IntegralvariationService integralvariationService;

    /**
     * 获取积分变动信息集合
     * @param userId 用户id
     * @param model 模型
     * @return 逻辑字符
     */
    @RequestMapping("/{userNickName}/{userId}/getVariationList.html")
    public String getVariationList(@PathVariable String userNickName,@PathVariable String userId, Model model){
        //获取集合
        List<Integralvariation> list = integralvariationService.getIntegralvariationByUserId(userId);
        //放入模型中
        model.addAttribute("list",list);
        model.addAttribute("userNickName",userNickName);
        return "integralVariation";
    }
}

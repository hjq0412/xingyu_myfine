package cn.xingyu.myfine.controller;


import cn.xingyu.myfine.pojo.User;
import cn.xingyu.myfine.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 * User控制器
 * @author You
 * @since 2019-01-08
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 注入service
     */
    @Resource(name = "usersService")
    private UserService userService;

    /**
     * 日志输出
     */
    private  final  static Logger  logger= LoggerFactory.getLogger(UserController.class);

    /**
     * 获取用户积分list
     * @param model 模型
     * @return 逻辑字符串
     */
    @RequestMapping("/getTotalIntegral.html")
    public String getTotalIntegral(Model model){
        //调用service方法
        List<User> list=userService.getTotalIntegral();
        //将集合放入model中
        model.addAttribute("totalIntegralList",list);
        return "IntegralList";
    }

}

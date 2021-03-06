package cn.xingyu.myfine.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author 何嘉琦
 * @date 2019-01-10-9:27
 */
@Controller
public class CommonJumpController {

    /**
     * 跳转登录页面
     *
     * @return 逻辑字符串
     */
    @RequestMapping("/toLogin.html")
    public String toLogin() {
        return "login";
    }

    /**
     * 退出登录
     *
     * @param session 会话
     * @return 逻辑字符串
     */
    @RequestMapping("/loginOut.html")
    public String loginOut(HttpSession session) {
        session.removeAttribute("manager");
        return "redirect:toLogin.html";
    }

    /**
     * 跳转至首页
     *
     * @return 逻辑字符串
     */
    @RequestMapping("/index.html")
    public String toIndex() {
        return "index";
    }

    /**
     * 跳转至积分页
     * @return 逻辑字符串
     */
    @RequestMapping("/integralList.html")
    public  String toIntegralList(){
        return "IntegralList";
    }

}

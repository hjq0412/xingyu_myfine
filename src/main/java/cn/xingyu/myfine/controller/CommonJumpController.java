package cn.xingyu.myfine.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
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

package cn.xingyu.myfine.controller;


import cn.xingyu.myfine.pojo.Manager;
import cn.xingyu.myfine.service.ManagerService;
import cn.xingyu.myfine.util.Data;
import cn.xingyu.myfine.util.JsonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 * 管理员controller
 *
 * @author You
 * @since 2019-01-07
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    /**
     * 注入service
     */
    @Resource(name = "/manService")
    private ManagerService managerService;

    /**
     * 日志输出
     */
    private Logger logger = LoggerFactory.getLogger(ManagerController.class);


    /**
     * 登录处理
     *
     * @param formLogin 表单json
     * @param session   会话
     * @return json对象
     */
    @PostMapping("/login.html")
    @ResponseBody
    public Object login(@RequestParam("formLogin") String formLogin, HttpSession session) {
        //日志输出前台请求的json
        logger.info(formLogin);
        //将从前台传来的表单json对象转换为对应的pojo
        Manager manager = JsonUtils.jsonToPojo(formLogin, Manager.class);
        //实例化 保存json结果的对象
        Data data = new Data();
        //调用service的登陆方法
        Manager manager2 = managerService.login(manager.getManagerCode(), manager.getPassword());
        //如果对象不为空 则登录成功 并将管理员对象放入session
        if (manager2 != null) {
            data.setResult("success");
            data.setMessage("登录成功！");
            session.setAttribute("manager", manager2);
        } else {
            data.setResult("failed");
            data.setMessage("登录失败，请确认您的用户名或密码！");
        }
        //日志输出响应的json
        logger.info(JsonUtils.objectToJson(data));
        //返回 将保存json结果的对象转换为json对象
        return JsonUtils.objectToJson(data);
    }


    /**
     * 根据管理员id 获取管理员对象
     *
     * @param id 管理员id
     * @return json对象
     */
    @RequestMapping("/toUpdateManager.html")
    @ResponseBody
    public Object toUpdateManager(@RequestParam("id") String id) {
        Manager manager = managerService.getManagerById(id);
        //日志输出响应的json
        logger.info(JsonUtils.objectToJson(manager));
        return JsonUtils.objectToJson(manager);
    }

    /**
     * 校验code是否重复
     *
     * @param code 管理员code
     * @return json
     */
    @RequestMapping("/checkCode.html")
    @ResponseBody
    public Object checkCode(@RequestParam("code") String code) {
        Data data = new Data();
        if (code == "") {
            data.setResult("null");
            data.setMessage("<span style='color:red'>该管理员CODE不可为空</span>");
        } else {
            int count = managerService.getManagerByCode(code);
            if (count > 0) {
                data.setResult("failed");
                data.setMessage("<span style='color:red'>该管理员CODE不可用</span>");
            } else {
                data.setResult("success");
                data.setMessage("<span style='color:red'>该管理员CODE可以使用</span>");
            }
        }
        //日志输出响应的json
        logger.info(JsonUtils.objectToJson(data));
        return JsonUtils.objectToJson(data);
    }

    /**
     * 修改管理员对象
     *
     * @param formUpdate 修改管理员表单的json字符串
     * @param session    会话
     * @return 返回保存json信息的json对象
     */
    @RequestMapping("/updateManager.html")
    @ResponseBody
    public Object updateManager(@RequestParam("formUpdate") String formUpdate, HttpSession session) {
        //日志输出前台请求的json
        logger.info(formUpdate);
        //将从前台传来的表单json对象转换为对应的pojo
        Manager manager = JsonUtils.jsonToPojo(formUpdate, Manager.class);
        //实例化 保存json结果的对象
        Data data = new Data();
        boolean flag = managerService.updateManager(manager);
        if (flag) {
            data.setResult("success");
            data.setMessage("修改成功！");
            //如果修改成功移除之前session中保存的对象  保存为修改后的管理员对象
            session.removeAttribute("manager");
            session.setAttribute("manager", manager);
        } else {
            data.setResult("failed");
            data.setMessage("修改失败！");
        }

        //返回 将保存json结果的对象转换为json对象
        return JsonUtils.objectToJson(data);
    }

}

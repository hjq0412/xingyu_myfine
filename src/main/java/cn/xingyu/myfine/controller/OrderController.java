package cn.xingyu.myfine.controller;


import cn.xingyu.myfine.pojo.Order;
import cn.xingyu.myfine.service.OrderService;
import cn.xingyu.myfine.util.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
@RequestMapping("/order")
public class OrderController {

    /**
     * 注入orderService
     */
    @Resource(name = "orService")
    private OrderService orderService;

    /**
     * 获取所有订单
     * @param index  起始页
     * @param model 模型
     * @return 逻辑字符
     */
    @RequestMapping("/getOrderAll.html")
    public String getAllOrder(@RequestParam(value = "pageIndex", defaultValue = "1") Integer index, Model model){
        //开始分页 声明分页信息（当前页，每页记录数）
        //查询之前传入 当前页 和页面容量
        PageHelper.startPage(index, 10);
        //获取订单集合
        List<Order> list = orderService.getOrderList();
        //查询调用方法对查询结果进行包装成PageInfo对象
        PageInfo pageInfo = new PageInfo<Order>(list);
        //塞进model
        model.addAttribute("page", pageInfo);
        return  "allOrder";
    }

    /**
     * 获取未付款订单
     * @param index  起始页
     * @param model 模型
     * @return 逻辑字符
     */
    @RequestMapping("/getOrderNoPay.html")
    public String getOrderNoPay(@RequestParam(value = "pageIndex", defaultValue = "1") Integer index, Model model){
        //开始分页 声明分页信息（当前页，每页记录数）
        //查询之前传入 当前页 和页面容量
        PageHelper.startPage(index, 10);
        //获取订单集合
        List<Order> list = orderService.getOrderListByPay(2);
        //查询调用方法对查询结果进行包装成PageInfo对象
        PageInfo pageInfo = new PageInfo<Order>(list);
        //塞进model
        model.addAttribute("page", pageInfo);
        return  "NoPay";
    }

    /**
     * 获取已发货 未订单
     * @param index  起始页
     * @param model 模型
     * @return 逻辑字符
     */
    @RequestMapping("/getOrderDelivery.html")
    public String getOrderDelivery(@RequestParam(value = "pageIndex", defaultValue = "1") Integer index, Model model,String isDelivery){
        //开始分页 声明分页信息（当前页，每页记录数）
        //查询之前传入 当前页 和页面容量
        PageHelper.startPage(index, 10);
        //获取订单集合
        List<Order> list = orderService.getOrdreListByDelivery(Integer.parseInt(isDelivery));
        //查询调用方法对查询结果进行包装成PageInfo对象
        PageInfo pageInfo = new PageInfo<Order>(list);
        //塞进model
        model.addAttribute("page", pageInfo);
        return  "orderDelivery";
    }
}

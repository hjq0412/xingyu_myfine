package cn.xingyu.myfine.controller;


import cn.xingyu.myfine.dto.OrderDetailDto;
import cn.xingyu.myfine.pojo.Orderdetail;
import cn.xingyu.myfine.service.OrderdetailService;
import cn.xingyu.myfine.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
@Controller
@RequestMapping("/orderdetail")
public class OrderdetailController {

    /**
     * 日志输出
     */
    private static final Logger log= LoggerFactory.getLogger(OrderdetailController.class);
    /**
     * z注入
     */
    @Autowired
    @Qualifier("detailService")
    private OrderdetailService orderdetailService;

    /**
     * 根据订单id获取订单详细信息
     *
     * @param id 订单id
     * @return json对象
     */
    @RequestMapping("/getOrderDetail.html")
    @ResponseBody
    public Object getOrderDetailInfo(@RequestParam("id") String id) {
        OrderDetailDto orderdetail = orderdetailService.getOrderDetailInfo(id);
        log.info(JsonUtils.objectToJson(orderdetail));
        return JsonUtils.objectToJson(orderdetail);
    }
}

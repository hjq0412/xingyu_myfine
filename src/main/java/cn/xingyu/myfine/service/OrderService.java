package cn.xingyu.myfine.service;

import cn.xingyu.myfine.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
public interface OrderService extends IService<Order> {

    /**
     * 查询全部订单
     * @return 订单list
     */
    List<Order> getOrderList();

    /**
     * 查询未 付款订单
     * @return 未付款订单list
     */
    List<Order> getOrderListByPay(Integer isPay);

    /**
     * 查询已 未 发货订单
     * @return
     */
    List<Order> getOrdreListByDelivery(Integer isDelivery);



}

package cn.xingyu.myfine.service.impl;

import cn.xingyu.myfine.pojo.Order;
import cn.xingyu.myfine.mapper.OrderMapper;
import cn.xingyu.myfine.pojo.Orderdetail;
import cn.xingyu.myfine.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *  订单service实现类
 * @author You
 * @since 2019-01-08
 */
@Service("orService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {


    @Resource
    private OrderMapper orderMapper;

    /**
     * 查询全部订单
     * @return 订单list
     */
    @Override
    public List<Order> getOrderList() {
        List<Order> list= orderMapper.getAllOrder();
        return list;
    }

    /**
     * 查询未付款订单
     * @return 未付款订单list
     */
    @Override
    public List<Order> getOrderListByPay(Integer isPay) {
        return orderMapper.getOrderListByPay(isPay);
    }

    /**
     * 查询已 未 发货订单
     * @return list
     */
    @Override
    public List<Order> getOrdreListByDelivery(Integer isDelivery) {
        return orderMapper.getOrdreListByDelivery(isDelivery);
    }

}

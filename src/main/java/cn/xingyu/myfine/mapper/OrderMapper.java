package cn.xingyu.myfine.mapper;

import cn.xingyu.myfine.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 查询未 付款订单
     * @return 未付款订单list
     */
    List<Order> getOrderListByPay(@Param("isPay") Integer isPay);

    /**
     * 查询已 未 发货订单
     * @return
     */
    List<Order> getOrdreListByDelivery(@Param("isDelivery")Integer isDelivery);
}

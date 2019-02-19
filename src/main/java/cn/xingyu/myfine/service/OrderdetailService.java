package cn.xingyu.myfine.service;

import cn.xingyu.myfine.dto.OrderDetailDto;
import cn.xingyu.myfine.pojo.Orderdetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
public interface OrderdetailService extends IService<Orderdetail> {

    /**
     * 根据订单id获取订单详细信息
     *
     * @param id 订单id
     * @return Order
     */
    OrderDetailDto getOrderDetailInfo(String id);

}

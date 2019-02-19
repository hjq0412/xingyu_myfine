package cn.xingyu.myfine.service.impl;

import cn.xingyu.myfine.dto.OrderDetailDto;
import cn.xingyu.myfine.pojo.Orderdetail;
import cn.xingyu.myfine.mapper.OrderdetailMapper;
import cn.xingyu.myfine.service.OrderdetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
@Service("detailService")
public class OrderdetailServiceImpl extends ServiceImpl<OrderdetailMapper, Orderdetail> implements OrderdetailService {

    /**
     * 注入mapper
     */
    @Resource
    private OrderdetailMapper orderdetailMapper;

    /**
     * 根据订单id获取订单详细信息
     * @param id 订单id
     * @return Order
     */
    @Override
    public OrderDetailDto getOrderDetailInfo(String id) {
        return orderdetailMapper.getOrderDetailById(id);
    }
}

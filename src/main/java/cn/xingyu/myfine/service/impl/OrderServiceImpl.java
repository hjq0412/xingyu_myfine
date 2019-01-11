package cn.xingyu.myfine.service.impl;

import cn.xingyu.myfine.pojo.Order;
import cn.xingyu.myfine.mapper.OrderMapper;
import cn.xingyu.myfine.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}

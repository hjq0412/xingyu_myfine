package cn.xingyu.myfine.mapper;

import cn.xingyu.myfine.dto.OrderDetailDto;
import cn.xingyu.myfine.pojo.Orderdetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
public interface OrderdetailMapper extends BaseMapper<Orderdetail> {


    /**
     * 根据订单id获取订单详细信息
     * @param id 订单id
     * @return 订单详细对象
     */
    OrderDetailDto getOrderDetailById(@Param("id") String id);
}

package cn.xingyu.myfine.mapper;

import cn.xingyu.myfine.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 查询二级分类的商品
     * @param level2Id 二级分类id
     * @return 集合
     */
    List<Product> getProListByLevel2Id(String level2Id);
}

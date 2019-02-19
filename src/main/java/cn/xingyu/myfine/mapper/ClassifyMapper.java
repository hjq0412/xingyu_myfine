package cn.xingyu.myfine.mapper;

import cn.xingyu.myfine.pojo.Classify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
public interface ClassifyMapper extends BaseMapper<Classify> {

    /**
     * 查询是否存在子分类
     * @param id 分类id
     * @return integer
     */
    Integer existsChild(@Param("id") String id);

    /**
     * 查询一级分类对应的二级分类
     * @param id  一级分类id
     * @return 二级分类集合
     */
    List<Classify> getLevel1Children(@Param("id") String id);

    /**
     * 查询一级分类
     * @return 一级分类名称集合
     */
    List<Classify> getLevel1();
}

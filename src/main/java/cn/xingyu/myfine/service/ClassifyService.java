package cn.xingyu.myfine.service;

import cn.xingyu.myfine.pojo.Classify;
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
public interface ClassifyService extends IService<Classify> {


    /**
     * 获取分类list
     * @return list
     */
    List<Classify>  getClassifyList();
}

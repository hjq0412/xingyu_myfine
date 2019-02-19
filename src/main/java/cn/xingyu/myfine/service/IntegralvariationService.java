package cn.xingyu.myfine.service;

import cn.xingyu.myfine.pojo.Integralvariation;
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
public interface IntegralvariationService extends IService<Integralvariation> {


    /**
     * 根据用户id查询对应的积分变动信息
     * @param userId 用户id
     * @return 用户积分变动信息集合
     */
    List<Integralvariation> getIntegralvariationByUserId(String userId);
}

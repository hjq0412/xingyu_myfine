package cn.xingyu.myfine.service;

import cn.xingyu.myfine.pojo.User;
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
public interface UserService extends IService<User> {

    /**
     * 获取用户的积分信息
     * @return list
     */
    List<User> getTotalIntegral();

}

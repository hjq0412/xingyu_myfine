package cn.xingyu.myfine.service.impl;

import cn.xingyu.myfine.pojo.User;
import cn.xingyu.myfine.mapper.UserMapper;
import cn.xingyu.myfine.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
@Service("usersService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 注入userMapper
     */
    @Resource
    private UserMapper userMapper;

    /**
     * 获取用户的积分信息
     * @return list
     */
    @Override
    public List<User> getTotalIntegral() {
        //AR
        User user= new User();
        //调用查询
        List<User> list=user.selectAll();
        return list;
    }
}

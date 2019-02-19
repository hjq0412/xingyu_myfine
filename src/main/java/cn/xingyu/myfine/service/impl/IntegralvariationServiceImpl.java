package cn.xingyu.myfine.service.impl;

import cn.xingyu.myfine.pojo.Integralvariation;
import cn.xingyu.myfine.mapper.IntegralvariationMapper;
import cn.xingyu.myfine.service.IntegralvariationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
@Service("integralvarService")
public class IntegralvariationServiceImpl extends ServiceImpl<IntegralvariationMapper, Integralvariation> implements IntegralvariationService {

    /**
     * 根据用户id查询对应的积分变动信息
     *
     * @param userId 用户id
     * @return 用户积分变动信息集合
     */
    @Override
    public List<Integralvariation> getIntegralvariationByUserId(String userId) {
        Integralvariation integralvariation = new Integralvariation();
        //创建查询条件
        QueryWrapper<Integralvariation> wrapper = new QueryWrapper<>();
        wrapper.eq("userId", userId);
        //获取查询结果
        List<Integralvariation> list = integralvariation.selectList(wrapper);
        return list;
    }
}

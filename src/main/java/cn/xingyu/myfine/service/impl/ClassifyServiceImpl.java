package cn.xingyu.myfine.service.impl;

import cn.xingyu.myfine.pojo.Classify;
import cn.xingyu.myfine.mapper.ClassifyMapper;
import cn.xingyu.myfine.service.ClassifyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {

    /**
     * 获取分类list
     * @return list
     */
    @Override
    public List<Classify> getClassifyList() {
        Classify classify=new Classify();
        List<Classify> list= classify.selectAll();
        return list;
    }
}

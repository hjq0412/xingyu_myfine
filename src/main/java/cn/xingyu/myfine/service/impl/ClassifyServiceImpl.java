package cn.xingyu.myfine.service.impl;

import cn.xingyu.myfine.mapper.ClassifyMapper;
import cn.xingyu.myfine.pojo.Classify;
import cn.xingyu.myfine.service.ClassifyService;
import cn.xingyu.myfine.util.JsonUtils;
import cn.xingyu.myfine.util.RedisOperator;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 * 分类service实现类
 *
 * @author You
 * @since 2019-01-08
 */
@Service("classService")
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {

    /**
     * 日志输出
     */
    private final static Logger logger = LoggerFactory.getLogger(ClassifyServiceImpl.class);

    /**
     * redis操作类
     */
    @Autowired
    private RedisOperator redisOperator;

    /**
     * 获取分类list
     * @return list
     */
    @Override
    public List<Classify> getClassifyList() {
        List<Classify> list = null;
        try {
            //从redis中获取分类集合json串
            String classifyList = redisOperator.get("classifyList");
            logger.info(classifyList);
            list = JsonUtils.jsonToList(classifyList, Classify.class);
            if (classifyList == null) {
                //redis为空 重新查询数据库
                Classify classify = new Classify();
                list = classify.selectAll();
                //查到之后  放入redis
                if (list != null) {
                    redisOperator.set("classifyList", JsonUtils.objectToJson(list));
                }
                logger.info("查询了数据库！");
            }
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return list;
    }

    /**
     * 获取一级分类
     *
     * @return list
     */
    @Override
    public List<Classify> getClassifyTypeOne() {
        return null;
    }

    /**
     * 获取二级分类
     *
     * @return list
     */
    @Override
    public List<Classify> getClassifyTypeTwo() {
        return null;
    }
}

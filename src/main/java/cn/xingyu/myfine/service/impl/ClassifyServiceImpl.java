package cn.xingyu.myfine.service.impl;

import cn.xingyu.myfine.mapper.ClassifyMapper;
import cn.xingyu.myfine.pojo.Classify;
import cn.xingyu.myfine.service.ClassifyService;
import cn.xingyu.myfine.util.JsonUtils;
import cn.xingyu.myfine.util.RedisOperator;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
     * 获取分类集合
     *
     * @return list
     */
    @Override
    public List<Classify> getClassifyList() {
        List<Classify> list = null;
        /*try {
            //从redis中获取分类集合json串
            String classifyList = redisOperator.get("classifyList");
            logger.info(classifyList);
            list = JsonUtils.jsonToList(classifyList, Classify.class);
            if (classifyList == null) {*/
                //redis为空 重新查询数据库*/
                Classify classify = new Classify();
                list = classify.selectAll();
                /*//查到之后  放入redis
                if (list != null) {
                    redisOperator.set("classifyList", JsonUtils.objectToJson(list));
                }
                logger.info("查询了数据库！");
            }
        } catch (Exception e) {
            logger.info(e.toString());
        }*/
        return list;
    }

    /**
     * 根据id获取分类信息
     *
     * @return 分类对象信息
     */
    @Override
    public Classify getClassifyById(String id ) {
        Classify classify=new Classify();
        try {
            classify = classify.selectById(Long.valueOf(id));
        }catch (Exception e){
            //输出异常信息
            logger.info(e.toString());
        }
        return classify;
    }

    /**
     * 更新分类
     * @param classify 对象
     * @return true 修改成功
     */
    @Override
    public boolean updateClassify(Classify classify) {
        boolean flag=false;
        flag=classify.updateById();
        logger.info("更新："+flag);
        return flag;
    }

    /**
     * 新增分类
     * @param classify 对象
     * @return true新增成功
     */
    @Override
    public boolean addClassify(Classify classify) {
        boolean flag=false;
        classify.insert();
        return false;
    }


}

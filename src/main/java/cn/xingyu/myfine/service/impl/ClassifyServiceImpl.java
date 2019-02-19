package cn.xingyu.myfine.service.impl;

import cn.xingyu.myfine.mapper.ClassifyMapper;
import cn.xingyu.myfine.mapper.ProductMapper;
import cn.xingyu.myfine.pojo.Classify;
import cn.xingyu.myfine.pojo.Product;
import cn.xingyu.myfine.service.ClassifyService;
import cn.xingyu.myfine.util.JsonUtils;
import cn.xingyu.myfine.util.RedisOperator;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
     * 注入商品mapper
     */
    @Resource
    private ProductMapper productMapper;
    @Resource
    private ClassifyMapper classifyMapper;


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
    public Classify getClassifyById(String id) {
        Classify classify = new Classify();
        try {
            classify = classify.selectById(Long.valueOf(id));
        } catch (Exception e) {
            //输出异常信息
            logger.info(e.toString());
        }
        return classify;
    }

    /**
     * 更新分类
     *
     * @param classify 对象
     * @return true 修改成功
     */
    @Override
    public boolean updateClassify(Classify classify) {
        boolean flag = false;
        flag = classify.updateById();
        logger.info("更新：" + flag);
        return flag;
    }

    /**
     * 新增分类
     *
     * @param classify 对象
     * @return true新增成功
     */
    @Override
    public boolean addClassify(Classify classify) {
        boolean flag = false;
        flag = classify.insert();
        return flag;
    }

    /**
     * 删除分类
     *
     * @param id 分类id
     * @return true 删除成功
     */
    @Override
    public boolean delClassify(String id, String type) {
        boolean flag = false;

        //删除之前要先判断该分类下是否有子分类 然后判断该子分类下有无商品
        Integer productCount = 0;//商品数量
        QueryWrapper<Classify> wrapper = null;
        Product product = new Product();

        Classify classify = new Classify();
        if (type.equals("1")) {
            //判断该分类下是否存在子分类
            Integer count = classifyMapper.existsChild(id);
            if (count > 0) {//表示存在子分类 直接跳出不能删除
                flag = false;
            } else {//
                //判断该一级分类下有无商品
                productCount = product.selectCount(new QueryWrapper<Product>().eq("level1Id", id));
                if (productCount > 0) {//表示存在商品不能删除该分类  直接跳出
                    flag = false;
                } else {
                    flag = classify.deleteById(id);
                }
            }
        } else {
            //判断二级分类下有无商品
            productCount = product.selectCount(new QueryWrapper<Product>().eq("level2Id", id));
            if (productCount > 0) {//表示存在商品不能删除该分类  直接跳出
                flag = false;
            } else {
                flag = classify.deleteById(id);
            }
        }
        return flag;
    }

    /**
     * 根据一级分类id获取对应的二级分类的集合
     *
     * @param level1Id 一级分类id
     * @return 集合
     */
    @Override
    public List<Classify> getLevel1IdChilren(String level1Id) {
        return classifyMapper.getLevel1Children(level1Id);
    }

    /**
     * 获取所有的一级分类
     *
     * @return 一级分类集合
     */
    @Override
    public List<Classify> getLevel1() {
        return classifyMapper.getLevel1();
    }
}

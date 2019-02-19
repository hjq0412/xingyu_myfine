package cn.xingyu.myfine.service.impl;

import cn.xingyu.myfine.pojo.Product;
import cn.xingyu.myfine.mapper.ProductMapper;
import cn.xingyu.myfine.service.ProductService;
import cn.xingyu.myfine.util.JsonUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
@Service(value = "proService")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private ProductMapper productMapper;
    /**
     * 日志输出
     */
    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    /**
     * 获取最新上架的五条商品信息
     *
     * @return 商品集合
     */
    @Override
    public List<Product> getNewProduct() {
        //使用AR
        Product product = new Product();
        //设置查询条件
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("launchTime");
        wrapper.last("limit 5");
        //调用AR方法将查询条件对象传入
        List<Product> list = product.selectList(wrapper);
        //日志输出
        logger.info(JsonUtils.objectToJson(list));
        return list;
    }

    /**
     * 获取商品信息不包括最新的前五条信息
     *
     * @return list
     */
    @Override
    public List<Product> getProductNotFive() {
        //AR
        Product product = new Product();
        //查询商品表的所有的集合 通过list的size方法获得总共条数
        List<Product> listAll = product.selectAll();
        //设置条件
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc(true, "launchTime");
        wrapper.last("limit 5," + listAll.size());
        //查询集合
        List<Product> list = product.selectList(wrapper);
        return list;
    }

    /**
     * 获取销量最多的商品  根据销量排序商品
     *
     * @return list
     */
    @Override
    public List<Product> getProductByBuyCounts() {
        //Ar
        Product product = new Product();
        //设置查询条件
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("buyCounts");
        //查询
        List<Product> list = product.selectList(wrapper);
        return list;
    }

    /**
     * 根据商品id查询具体商品
     *
     * @param id 商品id
     * @return 商品对象
     */
    @Override
    public Product getProductById(String id) {
        //AR
        Product product = new Product();
        //将string转换为long放入对象中
        product.setId(Long.valueOf(id));
        //查询
        product = product.selectById();
        return product;
    }

    /**
     * 获取所有商品信息的集合
     *
     * @return list
     */
    @Override
    public List<Product> getProductList() {
        //AR
        Product product = new Product();
        //查询获取所有商品信息
        List<Product> productList = product.selectAll();
        return productList;
    }

    /**
     * 根据id 删除商品   假删除 修改状态
     *
     * @param id 商品id
     * @return true成功
     */
    @Override
    public boolean delPro(String id) {
        Product product = new Product();
        product.setId(Long.valueOf(id));
        product.setIsDel(Long.valueOf("1"));
        boolean flag = product.updateById();
        return flag;
    }

    /**
     * 根据id 上架商品   修改状态
     *
     * @param id 商品id
     * @return true成功
     */
    @Override
    public boolean upPro(String id) {
        Product product = new Product();
        product.setId(Long.valueOf(id));
        product.setIsDel(Long.valueOf("2"));
        boolean flag = product.updateById();
        return flag;
    }

    /**
     * 商品持久化操作
     * 如果存在该对象即为修改 否则为新增 insertOrUpdate
     *
     * @param product 商品对象
     * @return true 成功
     */
    @Override
    public boolean persistenceProduct(Product product) {
        boolean flag = false;
        product.setLaunchTime(LocalDateTime.now());
        flag = product.insertOrUpdate();
        return flag;
    }

    /**
     * 根据二级分类id查询所有对应的商品
     *
     * @param level2Id 二级分类id
     * @return 商品list
     */
    @Override
    public List<Product> getProListByLevel2Id(String level2Id) {
        return productMapper.getProListByLevel2Id(level2Id) ;
    }
}

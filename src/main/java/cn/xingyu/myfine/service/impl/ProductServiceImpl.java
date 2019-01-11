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

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
@Service(value = "proService")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    /**
     * 日志输出
     */
    private Logger logger= LoggerFactory.getLogger(ProductServiceImpl.class);

    /**
     * 获取最新上架的五条商品信息
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
        List<Product> list= product.selectList(wrapper);
        //日志输出
        logger.info(JsonUtils.objectToJson(list));
        return list;
    }

    /**
     * 获取商品信息不包括最新的前五条信息
     * @return list
     */
    @Override
    public List<Product> getProductNotFive() {
        //AR
        Product product= new Product();
        //查询商品表的所有的集合 通过list的size方法获得总共条数
        List<Product> listAll=product.selectAll();
        //设置条件
        QueryWrapper<Product> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc(true,"launchTime");
        wrapper.last("limit 5,"+listAll.size());
        //查询集合
        List<Product> list= product.selectList(wrapper);
        return list;
    }

    /**
     * 获取销量最多的商品  根据销量排序商品
     * @return list
     */
    @Override
    public List<Product> getProductByBuyCounts() {
        //Ar
        Product product = new Product();
        //设置查询条件
        QueryWrapper<Product> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("buyCounts");
        //查询
        List<Product> list = product.selectList(wrapper);
        return list;
    }

    /**
     * 根据商品id查询具体商品
     * @param id 商品id
     * @return 商品对象
     */
    @Override
    public Product getProductById(String id) {
        //AR
        Product product=new Product();
        //将string转换为long放入对象中
        product.setId(Long.valueOf(id));
        //查询
        product=product.selectById();
        return product;
    }

    /**
     * 获取所有商品信息的集合
     * @return list
     */
    @Override
    public List<Product> getProductList() {
        //AR
        Product product= new Product();
        //查询获取所有商品信息
        List<Product> productList=product.selectAll();
        return productList;
    }
}

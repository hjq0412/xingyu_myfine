package cn.xingyu.myfine.service;

import cn.xingyu.myfine.pojo.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *  商品service
 * @author You
 * @since 2019-01-08
 */
public interface ProductService extends IService<Product> {


    /**
     * 获取最新上架的五条商品信息
     * @return 商品集合
     */
    List<Product> getNewProduct();

    /**
     * 获取商品信息不包括最新的前五条信息
     * @return list
     */
    List<Product> getProductNotFive();

    /**
     * 获取销量最多的商品  根据销量排序商品
     * @return list
     */
    List<Product> getProductByBuyCounts();

    /**
     * 根据商品id查询具体商品
     * @param id 商品id
     * @return 商品对象
     */
    Product getProductById(String id);

    /**
     * 获取所有商品信息的集合
     * @return list
     */
    List<Product> getProductList();

    /**
     * 新增商品
     * @param product
     * @return
     */
    boolean addProduct(Product product);

    /**
     * 修改商品信息
     * @param product
     * @return
     */
    boolean updateProduct(Product product);
}

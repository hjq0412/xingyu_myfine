package cn.xingyu.myfine.service;

import cn.xingyu.myfine.pojo.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 * 商品service
 *
 * @author You
 * @since 2019-01-08
 */
public interface ProductService extends IService<Product> {


    /**
     * 获取最新上架的五条商品信息
     *
     * @return 商品集合
     */
    List<Product> getNewProduct();

    /**
     * 获取商品信息不包括最新的前五条信息
     *
     * @return list
     */
    List<Product> getProductNotFive();

    /**
     * 获取销量最多的商品  根据销量排序商品
     *
     * @return list
     */
    List<Product> getProductByBuyCounts();

    /**
     * 根据商品id查询具体商品
     *
     * @param id 商品id
     * @return 商品对象
     */
    Product getProductById(String id);

    /**
     * 获取所有商品信息的集合
     *
     * @return list
     */
    List<Product> getProductList();

    /**
     * 商品持久化操作
     *
     * @param product 商品对象
     * @return true 成功
     */
    boolean persistenceProduct(Product product);

    /**
     * 根据id 删除商品   假删除 修改状态
     * @param id 商品id
     * @return true成功
     */
    boolean delPro(String id);

    /**
     * 根据id 删除商品   假删除 修改状态
     * @param id 商品id
     * @return true成功
     */
    boolean upPro(String id);

    /**
     * 根据二级分类id查询所有对应的商品
     * @param level2Id 二级分类id
     * @return 商品list
     */
    List<Product> getProListByLevel2Id(String level2Id);

}

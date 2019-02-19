package cn.xingyu.myfine.service;

import cn.xingyu.myfine.pojo.Classify;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author You
 * @since 2019-01-08
 */
public interface ClassifyService extends IService<Classify> {


    /**
     * 获取分类集合
     * @return list
     */
    List<Classify> getClassifyList();

    /**
     * 根据id获取分类信息
     * @return 分类对象信息
     */
    Classify getClassifyById(String id);

    /**
     * 更新分类
     * @param classify 对象
     * @return true 修改成功
     */
    boolean updateClassify(Classify classify);

    /**
     * 新增分类
     * @param classify 对象
     * @return true新增成功
     */
    boolean  addClassify(Classify classify);

    /**
     * 删除分类
     * @param id 分类id
     * @return true 删除成功
     */
    boolean delClassify(String id,String type);

    /**
     * 根据一级分类id获取对应的二级分类的集合
     * @param level1Id 一级分类id
     * @return 集合
     */
    List<Classify> getLevel1IdChilren(String level1Id);

    /**
     * 获取所有的一级分类
     * @return 一级分类集合
     */
    List<Classify> getLevel1();



}

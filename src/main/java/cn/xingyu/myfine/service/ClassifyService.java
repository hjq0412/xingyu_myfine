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

}

package cn.xingyu.myfine.service;

import cn.xingyu.myfine.pojo.Manager;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 * 管理员service
 * @author You
 * @since 2019-01-07
 */
public interface ManagerService extends IService<Manager> {

    /**
     * 登录
     * @param code 管理员code
     * @return 管理员对象
     */
    Manager login(String code,String pwd);

    /**
     * 根据管理员id获取管理员对象
     * @param id 管理员id
     * @return 管理员对象
     */
    Manager getManagerById(String id);

    /**
     * 校验管理员code是否重复
     * @param code 管理员code
     * @return int值 大于0则为重复 已存在
     */
    int getManagerByCode(String code);

    /**
     * 修改管理员信息
     * @param manager 管理员对象
     * @return Boolean  true为更新成功
     */
    Boolean updateManager(Manager manager);
}

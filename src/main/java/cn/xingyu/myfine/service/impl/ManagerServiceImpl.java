package cn.xingyu.myfine.service.impl;

import cn.xingyu.myfine.pojo.Manager;
import cn.xingyu.myfine.mapper.ManagerMapper;
import cn.xingyu.myfine.service.ManagerService;
import cn.xingyu.myfine.util.Data;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * <p>
 *  服务实现类
 * </p>
 *  管理员service实现类
 * @author You
 * @since 2019-01-07
 */
@Service("/manService")
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

    /**
     * 注入mapper
     */
    @Resource
    private  ManagerMapper managerMapper;

    /**
     * 日志输出
     */
    private final  static Logger logger= LoggerFactory.getLogger(ManagerServiceImpl.class);

    /**
     * 登录
     * @param code 管理员code
     * @return 管理员对象
     */
    @Override
    public Manager login(String code,String pwd) {
        Manager manager=new Manager();
        manager=manager.selectOne(new QueryWrapper<Manager>().eq("managerCode",code));
        if (manager.getPassword().equals(pwd)){
            return manager;
        }
        return  null;
    }

    /**
     * 根据管理员id获取管理员对象
     * @param id 管理员id
     * @return 管理员对象
     */
    @Override
    public Manager getManagerById(String id) {
        //AR
        Manager manager=new Manager();
        try {
            manager = manager.selectById(Long.valueOf(id));
        }catch (Exception e){
            //输出异常信息
            logger.info(e.toString());
        }
        return manager;
    }

    /**
     * 校验管理员code是否重复
     * @param code 管理员code
     * @return int值 大于1则为重复 已存在
     */
    @Override
    public int getManagerByCode(String code) {
        Manager manager=new Manager();
        //设置查询条件
        QueryWrapper<Manager> wrapper = new QueryWrapper<>();
        wrapper.eq("managerCode",code);
        //根据条件查询
        int num=  manager.selectCount(wrapper);
        return num;
    }

    /**
     * 修改管理员信息
     * @param manager 管理员对象
     * @return Boolean  true为更新成功
     */
    @Override
    public Boolean updateManager(Manager manager) {
        boolean flag=false;
        flag=manager.updateById();
        logger.info("更新："+flag);
        return flag;
    }
}

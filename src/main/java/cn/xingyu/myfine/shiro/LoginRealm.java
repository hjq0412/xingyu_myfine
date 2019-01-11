package cn.xingyu.myfine.shiro;

import cn.xingyu.myfine.pojo.Manager;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 认证授权的核心类自定义Realm   需要继承与认证授权相关的类AuthorizingRealm
 * @author 何嘉琦
 * @date 2019-01-07-22:24
 */
public class LoginRealm extends AuthorizingRealm {


    /**
     * 日志输出
     */
    private final  static Logger logger= LoggerFactory.getLogger(LoginRealm.class);

    /**
     * 获取当前类名
     * @return 类名
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * 授权时候用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证登录时用
     * @param authenticationToken  存储认证信息的token
     * @return 认证信息
     * @throws AuthenticationException 认证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.将传入的token强转成UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //获取从主体穿过来的用户名
        String code=usernamePasswordToken.getUsername();
        char[] pwd = usernamePasswordToken.getPassword();
        //控制台输出获取的用户名和密码
        logger.info(code+"/t"+pwd.toString());
        //从数据库获取凭证
        Manager manager = new Manager();
        manager=manager.selectOne(new QueryWrapper<Manager>().eq("managerCode",code));
        //第一个是 数据库查询的对象  第二个是数据库中的密码  第三个是当前类名
        return new SimpleAuthenticationInfo(manager,manager.getPassword(),this.getName());
    }
}

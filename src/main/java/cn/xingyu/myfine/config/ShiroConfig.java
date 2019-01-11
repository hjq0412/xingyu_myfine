package cn.xingyu.myfine.config;

import cn.xingyu.myfine.shiro.LoginRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 * @author 何嘉琦
 * @since 2019-01-07-23:01
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilter.setSecurityManager(securityManager);
        // 拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 设置login URL
        shiroFilter.setLoginUrl("/toLogin.html");
        //设置拦截规则
        filterChainDefinitionMap.put("/toLogin.html","anon");
        filterChainDefinitionMap.put("/manager/login.html","anon");
        //静态资源的处理
        filterChainDefinitionMap.put("/static/js/**", "anon");
        filterChainDefinitionMap.put("/static/css/**", "anon");
        filterChainDefinitionMap.put("/static/scripts/**", "anon");
        filterChainDefinitionMap.put("/static/fonts/**", "anon");
        filterChainDefinitionMap.put("/static/tools/**", "anon");
        filterChainDefinitionMap.put("/static/font-awesome/**", "anon");

        filterChainDefinitionMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilter;
    }


    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(LoginRealm loginRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(loginRealm);
        return securityManager;
    }

    @Bean
    public LoginRealm loginRealm() {
        LoginRealm realm = new LoginRealm();
        return realm;
    }

}

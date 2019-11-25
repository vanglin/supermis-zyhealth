package com.smartpro.mis.rest.modular.auth.security;

import com.smartpro.mis.rest.modular.auth.util.JWTToken;
import com.smartpro.mis.rest.common.database.UserBean;
import com.smartpro.mis.rest.common.database.UserService;
import com.smartpro.mis.rest.config.properties.JwtProperties;
import com.smartpro.mis.rest.modular.auth.util.JWTToken;
import com.smartpro.mis.rest.modular.auth.util.JwtTokenUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtProperties jwtProperties;

    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = jwtTokenUtil.getUsernameFromToken(principals.toString());
        UserBean user = userService.getUser(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(user.getRole());
        Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = jwtTokenUtil.getUsernameFromToken(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        UserBean userBean = userService.getUser(username);
        if (userBean == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!jwtTokenUtil.verify(token)){
            throw new AuthenticationException("Username or password error");
        }
//        jwtTokenUtil.parseToken(token);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token, token, "my_realm");

        return info;
    }
}

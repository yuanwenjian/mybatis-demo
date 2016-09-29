package com.yuanwj.config;

import com.yuanwj.entity.User;
import com.yuanwj.service.UserServiece;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.inject.Inject;

/**
 * Created by bmk on 16-9-29.
 */
public class ShiroRealm extends AuthorizingRealm {
    @Inject
    private UserServiece userServiece;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name=(String)principalCollection.fromRealm(getName()).iterator().next();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
        String userName=usernamePasswordToken.getUsername();
        User user=userServiece.findByName(userName);
        SecurityUtils.getSubject().getSession().setAttribute("user",user);
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(user.getName(),user.getName(),getName());
        return simpleAuthenticationInfo;
    }
}

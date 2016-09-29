package com.yuanwj.controller.login;

import com.yuanwj.entity.User;
import com.yuanwj.service.UserServiece;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

/**
 * Created by bmk on 16-9-21.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Inject
    private UserServiece userServiece;

    @RequestMapping(value = "/user/home")
    public String login(){
        System.out.println("sksddddddddddsllllldssddddddddsssssssss");
        return "login/login";
    }

    @RequestMapping(value = "/user/index")
    public String index(String name,String password){
        User user=userServiece.findByName(name);
        SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getName(),user.getPassword()));
        User user1=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
        System.out.println(user1.getName());
        System.out.println(user1.getPassword());
        return "login/index";
    }
}

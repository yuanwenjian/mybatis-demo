package com.yuanwj.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bmk on 16-9-21.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "/user/home")
    public String index(){
        System.out.println("sksddddddddddsllllldssddddddddsssssssss");
        return "login/index";
    }
}

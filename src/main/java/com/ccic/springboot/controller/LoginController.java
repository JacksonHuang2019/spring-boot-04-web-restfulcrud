package com.ccic.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author :hzs
 * @Date :Created in 15:14 2019/11/21
 * @Description :
 * Modified By   :
 * @Version ：
 **/
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession  session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            // 登录成功后 防止表单重复提交 重定向
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名或者密码错误");
            return  "login";
        }
    }
}

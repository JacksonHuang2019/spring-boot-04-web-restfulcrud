package com.ccic.springboot.controller;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

/**
 * @Author :hzs
 * @Date :Created in 16:00 2019/11/19
 * @Description :
 * Modified By   :
 * @Version ：
 **/
@Controller
public class Helloworld {

   /* @RequestMapping({"/","/index.xml"})
    public String index(){
        return"index";
    }*/

    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(){
        return "hello world";
    }
    @RequestMapping("/success")
    public String success(Map<String,Object> map) {

        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu","zhaoliu"));
        // /teplates/success.html
        return "success";
    }

    @Bean
    public ViewResolver myViewResolve(){
        return  new MyViewResove();
    }


    private  static class MyViewResove implements   ViewResolver{


        @Override
        public View resolveViewName(String viewNeme, Locale locale ){
            return  null;
        }




    }

}


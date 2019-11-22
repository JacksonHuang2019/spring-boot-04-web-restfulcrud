package com.ccic.springboot.config;

import com.ccic.springboot.component.LoginHandleIntercepter;
import com.ccic.springboot.component.MyLocaleResolve;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author :hzs
 * @Date :Created in 16:31 2019/11/20
 * @Description :
 * Modified By   :
 * @Version ：
 **/
// 扩展springMVC的功能
@Configuration
public class MyMvcConfig  extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送ccic请求，请求来到success页面
        registry.addViewController("/ccic").setViewName("success");
//        super.addViewControllers(registry);
    }

    @Bean
    public  WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {


            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                    registry.addViewController("/").setViewName("login");
                    registry.addViewController("/index.html").setViewName("login");
                    registry.addViewController("/main.html").setViewName("dashboard");

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandleIntercepter()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/user/login");
                //super.addInterceptors(registry);
            }
        };
        return adapter;
    }

    public LocaleResolver localeResolver() {
        return new MyLocaleResolve();
    }
}

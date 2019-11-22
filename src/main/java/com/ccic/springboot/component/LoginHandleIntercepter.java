package com.ccic.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author :hzs
 * @Date :Created in 15:57 2019/11/21
 * @Description :
 * Modified By   :
 * @Version ：
 **/
// 登录检查
public class LoginHandleIntercepter implements HandlerInterceptor {
    // 方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            // 未登录
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("index.html").forward(request,response);
            return false;

        } else {
            // 已登录 放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

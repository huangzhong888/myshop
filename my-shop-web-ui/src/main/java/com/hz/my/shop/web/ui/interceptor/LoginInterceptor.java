package com.hz.my.shop.web.ui.interceptor;

import com.hz.my.shop.web.ui.constant.SystemConstant;
import com.hz.my.shop.web.ui.dto.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: huangzhong
 * @Date: 2022/8/15 - 08 - 15 - 15:50
 * @Description: com.hz.my.shop.web.ui.interceptor
 * @version: 1.0
 */

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(SystemConstant.SESSION_USER_KEY);
       //未登录状态
        if(tbUser == null){
            return true;
        }
        //已登录状态
        else {
            httpServletResponse.sendRedirect("/index");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

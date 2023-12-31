package com.youkenhei.filter;

import com.alibaba.fastjson.JSONObject;
import com.youkenhei.pojo.Result;
import com.youkenhei.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String url = req.getRequestURL().toString();
//        log.info("URL地址是：{}",url);

        if (url.contains("login")) {
            log.info("登录操作，放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String jwt = req.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            log.info("token为空，返回error");
            Result error = Result.error("NOT_LOGIN");
            String errorStr = JSONObject.toJSONString(error);
            log.info(errorStr);
            resp.getWriter().write(errorStr);
            return;
        }

        try {
            log.info(jwt);
            Claims claims = JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析失败，返回error");
            Result error = Result.error("NOT_LOGIN");
            String errorStr = JSONObject.toJSONString(error);
            resp.getWriter().write(errorStr);
            return;
        }
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

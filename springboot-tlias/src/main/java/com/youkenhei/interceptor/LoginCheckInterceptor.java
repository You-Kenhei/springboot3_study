package com.youkenhei.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.youkenhei.pojo.Result;
import com.youkenhei.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override // 目标资源方法运行前运行，返回true则放行，返回false则不放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        String url = req.getRequestURL().toString();
//        log.info("URL地址是：{}",url);

        if (url.contains("login")) {
            log.info("登录操作，放行");
            return true;
        }

        String jwt = req.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            log.info("token为空，返回error");
            Result error = Result.error("NOT_LOGIN");
            String errorStr = JSONObject.toJSONString(error);
            log.info(errorStr);
            resp.getWriter().write(errorStr);
            return false;
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
            return false;
        }
        log.info("令牌合法，放行");

        return true;
    }

    @Override // 目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle````");
    }

    @Override // 视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion````");
    }
}

package com.ruoyi.web.controller.token;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.system.domain.TToken;
import com.ruoyi.system.service.ITTokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
@Slf4j
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private ITTokenService newTokenService;

    public static final String USER_KEY = "USER_ID";
    public static final String USER_INFO = "USER_INFO";
    public static final String LOGIN_TOKEN_KEY = "token";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Token annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Token.class);
        }else{
            return true;
        }
        //没有声明需要权限,或者声明不验证权限
        if(annotation == null || annotation.validate() == false){
            return true;
        }
        //从header中获取token
        String token = request.getHeader(LOGIN_TOKEN_KEY);
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(LOGIN_TOKEN_KEY);
        }

        if(token == null){
            log.info("token为空");
            throw new CustomException("用户未登录或身份已过期", 401);
        }

        QueryWrapper<TToken> wrapper = new QueryWrapper<>();
        wrapper.eq("token", token);
        //查询token信息
        TToken tToken = newTokenService.getOne(wrapper);

        if(tToken == null){
            log.info("token不正确，拒绝访问");
            throw new CustomException("用户未登录或身份已过期", 401);
        }

        if (!tToken.getExpireTime().after(new Date())) {
            log.info("token 已过期");
            throw new CustomException("用户未登录或身份已过期", 401);
        }

        //token校验通过，将用户信息放在request中，供需要用user信息的接口里从token取数据
        request.setAttribute(USER_KEY, tToken.getUserId());

        return true;
    }
}
 
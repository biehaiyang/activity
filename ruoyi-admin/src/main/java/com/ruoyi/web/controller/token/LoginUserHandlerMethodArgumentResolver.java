package com.ruoyi.web.controller.token;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.system.domain.TWebUser;
import com.ruoyi.system.service.ITWebUserService;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;


@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver
{

    @Resource
    private ITWebUserService webUserService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(UserConstants.class)&&methodParameter.hasParameterAnnotation(LoginUser.class);
    }
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        //获取登陆用户信息
        Object object = nativeWebRequest.getAttribute(AuthorizationInterceptor.USER_KEY, RequestAttributes.SCOPE_REQUEST);
        if(object == null){
            return null;
        }

        //获取用户Id
        long userId = Long.parseLong(String.valueOf(object));

        //获取用户信息
        TWebUser user = webUserService.getById(userId);

        return user;
    }
}

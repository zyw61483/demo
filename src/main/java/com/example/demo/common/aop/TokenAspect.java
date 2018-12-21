package com.example.demo.common.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.client.ResponseContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Order(1)
@Aspect
@Component
public class TokenAspect {

    @Pointcut("execution(public * com.example.demo.web.*.*(..))")
    public void tokenAspect() {
    }

    @Pointcut("within(com.example.demo.web.CommonController)")
    public void common() {

    }

    @Around("tokenAspect() && !common()")
    public void doBefore(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("x-demo-token");
        if (token == null) {
            HttpServletResponse response = attributes.getResponse();
            response.sendRedirect(request.getContextPath() + "/main");
            return;
        }
        pjp.proceed();
    }

}

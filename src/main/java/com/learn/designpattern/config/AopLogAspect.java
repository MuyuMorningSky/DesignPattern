//package com.learn.designpattern.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
///**
// * 1.声明切面
// */
//@Slf4j
//@Aspect
//public class AopLogAspect {
//    /**
//     * 2.申明切入点（execution表达式）
//     *
//     */
//    @Pointcut("execution(* com.learn.designpattern.core.*.*(..))")
//    public void serviceAspect() {
//    }
//
//    /**
//     * 3.声明通知方法
//     * @param joinPoint
//     */
//    @Before(value = "serviceAspect()")
//    public void methodBefore(JoinPoint joinPoint) {
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
//                .getRequestAttributes();
//        HttpServletRequest request = requestAttributes.getRequest();
//
//        // 打印请求内容
//        log.info("===============请求内容===============");
//        log.info("请求地址:" + request.getRequestURL().toString());
//        log.info("请求方式:" + request.getMethod());
//        log.info("请求类方法:" + joinPoint.getSignature());
//        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
//        log.info("===============请求内容===============");
//    }
//
//    @AfterReturning(returning = "obj", pointcut = "serviceAspect()")
//    public void methodAfterReturing(Object obj) {
//        log.info("--------------返回内容----------------");
//        log.info("Response内容:" + obj.toString());
//        log.info("--------------返回内容----------------");
//    }
//}

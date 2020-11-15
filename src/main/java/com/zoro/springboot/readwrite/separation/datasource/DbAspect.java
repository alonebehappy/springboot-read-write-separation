package com.zoro.springboot.readwrite.separation.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/15 21:55
 * @desc 该类优先于DynamicDataSource类执行
 */
@Slf4j
@Aspect
@Configuration
public class DbAspect {

    @Pointcut("@annotation(com.zoro.springboot.readwrite.separation.datasource.Read)")
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object setRead(ProceedingJoinPoint joinPoint) throws Throwable{
        try{
            DbThreadLocal.setDbType(DbThreadLocal.READ);
            return joinPoint.proceed();
        }finally {
            DbThreadLocal.clearDbType();
        }
    }


}

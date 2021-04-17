package cn.gdcp.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {

    @Before("pointcut()")
    public void before(){
        System.out.println("前置增强...");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("后置增强...");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前执行...");
        Object proceed = pjp.proceed();
        System.out.println("环绕后执行...");

        return proceed;
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("异常抛出...");
    }


    @After("pointcut()")
    public void after(){
        System.out.println("最终增强...");
    }

    @Pointcut("execution(* cn.gdcp.anno.*.*(..))")
    public void pointcut(){
    }

}

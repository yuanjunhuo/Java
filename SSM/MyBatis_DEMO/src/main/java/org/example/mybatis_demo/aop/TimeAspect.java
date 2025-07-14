package org.example.mybatis_demo.aop;




import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TimeAspect {

    // 指定作用域
    @Around("execution(* org.example.mybatis_demo.service.*.*(..))") // 切入点表达式！！！
    public Object TimeAspect(ProceedingJoinPoint joinPoint) throws Throwable {

        //记录开始时间
        long begin = System.currentTimeMillis();

        // 执行原始方法
       Object result = joinPoint.proceed();


       String classname = joinPoint.getTarget().getClass().getName();
       String methodName = joinPoint.getSignature().getName();
       Object[] args = joinPoint.getArgs();

       log.info(classname);
       log.info(methodName);
       log.info(String.valueOf(args));
       log.info((String) result);










        //记录结束时间
        long end = System.currentTimeMillis();
        log.info("方法执行耗时：{}ms", end - begin);

        return result;
    }

}

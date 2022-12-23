package com.bookss09.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* com.bookss09.service.impl.BookServiceImpl.update(..)) ||" +
            "execution(* com.bookss09.service.impl.BookServiceImpl.create(..)) ||" +
            "execution(* com.bookss09.service.impl.BookServiceImpl.updateAfterLoan(..))")
    public void changeNumberBook() {
    }

    @Before("changeNumberBook()")
    public void getLog(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before Change Number Book: Call " + methodName);
    }

    @AfterReturning("changeNumberBook()")
    public void getLogAfter(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After Change Number Book: Call " + methodName);
    }

    @Around("changeNumberBook()")
    public Object getLogRound(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Around Change Number Book: Call " + methodName);
        Object result = joinPoint.proceed(); //getList()
        logger.info("Around Change Number Book: End Call " + methodName);
        return result;
    }

    @Pointcut("execution(* com.bookss09.service.impl.BookServiceImpl.*(..))")
    public void bookService() {
    }

    @After("bookService()")
    public void doFinallyAdvice(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: End call " + methodName);
    }
}

package az.ingress.bankapp.aop;


import az.ingress.bankapp.entity.Ac;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class LoginAcpect {


    @Pointcut("execution(* az.ingress.bankapp.service.impl.Addimpl.updateAccount(..))")
    public void testPointcut() {

    }
//
//    @After("execution(* az.ingress.bankapp.service.impl.Addimpl.updateAccount(..))")
//    public void testLogin(JoinPoint joinPoint) {
//        // log.info("Begin update : {}",Thread.currentThread().getName());
//        log.warn("method name is :{}", joinPoint.getSignature().getName());
//        //  log.warn("method name is :{}",joinPoint.getSignature().getDeclaringType()); //clas gorsedir +paket
//        // log.warn("method name is :{}",joinPoint.getSignature().getDeclaringTypeName()); //paketi gorsedir
//        Double arg = (Double) joinPoint.getArgs()[1];
//        arg = 2.0;
//        log.warn("parametr valu is:  {}", arg);
//        if (arg == 2) throw new RuntimeException("xeta bas verdi");
//    }

//    @AfterThrowing("execution(* az.ingress.bankapp.service.impl.Addimpl.updateAccount(..))")
//    public void testLogin(JoinPoint joinPoint) {
//         log.info("Begin update : {}",Thread.currentThread().getName());
//        log.warn("method name is :{}", joinPoint.getSignature().getName());
//         log.warn("method name is :{}",joinPoint.getSignature().getDeclaringType()); //clas gorsedir +paket
//         log.warn("method name is :{}",joinPoint.getSignature().getDeclaringTypeName()); //paketi gorsedir
//        Double arg = (Double) joinPoint.getArgs()[1];
//        arg = 2.0;log.warn("parametr valu is:  {}", arg);
//    }

//    @Around("execution(* az.ingress.bankapp.service.impl.Addimpl.updateAccount(..))")//hem methodun evvelinde ve sonunda isliyir
//    public Object testLogin(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        log.warn("method name is :{}", joinPoint.getSignature().getName());
//        log.warn("method name is :{}",joinPoint.getSignature().getDeclaringType()); //clas gorsedir +paket
//        Double arg = (Double) joinPoint.getArgs()[1];
//        arg = 2.0;
//        log.warn("parametr valu is:  {}", arg);
//
//        Ac result= (Ac) joinPoint.proceed(); // proceeed methodu ise salmaq demekdir.
//
//        log.warn("result :{}",result);
//        result.setBalance(200);
//        return result;
//    }

    @Around("testPointcut()")//  around hem methodun evvelinde ve sonunda isliyir
    public Object testLogin(ProceedingJoinPoint joinPoint) throws Throwable {


        try {
            Ac result = (Ac) joinPoint.proceed();
            return result;
        } catch (RuntimeException e) {

            throw new Exception("xeta cixid");  //methodda olan xeta yox bu xeta cixacaq

        }

    }

    @Before("@annotation(az.ingress.bankapp.aop.CheckParam)")//
    public void testAnnotation(JoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CheckParam annotation = method.getAnnotation(CheckParam.class);
      if(!annotation.value().equals("strat")){
           throw new RuntimeException("Method alloved");
       }

    }

}

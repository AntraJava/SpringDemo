package net.antra.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DemoAspect {
	
	@Before("execution(* *.save*(..))")
    public void getNameAdvice(JoinPoint joinPoint){
        System.out.println("before save*");
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg: signatureArgs) {
           System.out.println("Arg: " + signatureArg);
        }
    }
	@AfterThrowing("execution(* *.test1234*(..))")
	public void afterTh(){
		System.out.println("AOP for test1234");
	}
	@After("execution(* *.save*(..))")
	public void afterMethod(){
		System.out.println("after save*");
	}
	@Around("execution(* *.save*(..))")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Before invoking save() method");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("After invoking save() method. Return value="+value);
        return value;
    }
}

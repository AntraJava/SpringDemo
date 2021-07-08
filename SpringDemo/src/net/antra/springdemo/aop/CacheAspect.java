package net.antra.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class CacheAspect {

    Map<Integer, Integer> values = new ConcurrentHashMap<>();

    @Around("@annotation(Cache)")
    public Object timeThisMethod(ProceedingJoinPoint pjp) {
        Integer index = (Integer)pjp.getArgs()[0];
        if (values.containsKey(index)) {
            System.out.println("Cache hit!");
            return values.get(index);
        }
        Object value = null;
        try {
            value = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        values.put(index, (Integer)value);

        return value;
    }
}

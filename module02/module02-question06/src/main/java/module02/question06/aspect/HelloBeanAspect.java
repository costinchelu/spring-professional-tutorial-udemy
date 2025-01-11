package module02.question06.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloBeanAspect {

    @Pointcut("within(module02.question06.beans.*)")
    public void withinBeansPackage() {
    }

    @Before("withinBeansPackage()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before - " + joinPoint.getSignature());
    }

    @After("withinBeansPackage()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after - " + joinPoint.getSignature());
    }
}

package module02.question08.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class HelloBeanAspect {

    @Before("execution(* module02..HelloBean.formatData(..))")
    public void beforeHelloBean(JoinPoint joinPoint) {
        System.out.println("HelloBeanAspect::beforeHelloBean <- start");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());

        System.out.println("HelloBeanAspect::beforeHelloBean <- stop\n\n");
    }

    @After("execution(* module02..HelloBean.formatData(..))")
    public void afterHelloBean(JoinPoint joinPoint) {
        System.out.println("\n\nHelloBeanAspect::afterHelloBean <- start");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());

        System.out.println("HelloBeanAspect::afterHelloBean <- stop\n\n");
    }

    @AfterReturning(value = "execution(* module02..HelloBean.formatData(..))", returning = "returnValue")
    public void afterReturningHelloBean(JoinPoint joinPoint, Object returnValue) {
        System.out.println("\n\nHelloBeanAspect::afterReturningHelloBean <- start");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());
        System.out.println("Return Value = " + returnValue);

        System.out.println("HelloBeanAspect::afterReturningHelloBean <- stop\n\n");
    }

    @AfterThrowing(value = "within(module02..HelloBean)", throwing = "exception")
    public void afterThrowingHelloBean(JoinPoint joinPoint, Exception exception) {
        System.out.println("\n\nHelloBeanAspect::afterThrowingHelloBean <- start");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());
        System.out.println("Exception = " + exception);

        System.out.println("HelloBeanAspect::afterThrowingHelloBean <- stop\n\n");
    }
}

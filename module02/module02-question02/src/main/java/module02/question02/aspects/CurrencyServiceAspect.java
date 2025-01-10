package module02.question02.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// aspects needs to be defined as beans
@Component
@Aspect
public class CurrencyServiceAspect {

    // a pointcut is a PREDICATE used to match a joint point - inform Spring in which part of the program we want the modified behaviour

    // advice = additional behaviour that is executed in all parts of the program that are matching pointcut

    // Spring uses the AspectJ pointcut expression language by default
    // @annotation = execution of the given types annotated with a specific annotation
    @Pointcut("@annotation(module02.question02.annotations.InTransaction)")
    public void transactionAnnotationPointcut() {
        // advice is on line 72
    }

    // within = execution of the given types inside a package
    @Pointcut("within(module02.question02.bls.*)")
    public void blsPackagePointcut() {
    }

    // @within = execution of the given types annotated with a specific annotation
    @Pointcut("@within(module02.question02.annotations.Secured)")
    public void securedClassPointcut() {
    }

    // execution = method execution (method with name getExchangeRate and any arguments)
    @Pointcut("execution(* module02.question02.bls.CurrencyService.getExchangeRate(..))")
    public void getExchangeRateMethodPointcut() {
    }

    // bean = execution for the Spring name
    @Pointcut("bean(currency_service)")
    public void namedBeanPointcut() {
    }

    // execution of the methods with the matched arguments
    @Pointcut("args(String, String, int)")
    public void stringsAndIntegerArgumentsMethodPointcut() {
    }

    // execution of the methods with the matched arguments annotated with the specific annotation
    @Pointcut("@args(module02.question02.annotations.Validated)")
    public void validatedArgumentPointcut() {
    }

    // targets specific class
    @Pointcut("target(module02.question02.bls.CurrencyService)")
    public void currencyServiceTargetPointcut() {
    }

    @Pointcut("@target(module02.question02.annotations.Secured)")
    public void currencyServiceSecuredTargetPointcut() {
    }

    @Pointcut("this(module02.question02.bls.CurrencyService)")
    public void currencyServiceThisPointcut() {
    }

    @Pointcut("blsPackagePointcut() && transactionAnnotationPointcut()")
    public void blsPackageAndInTransactionPointcut() {
    }


    @Before("transactionAnnotationPointcut()")
    public void beforeTransactionAnnotationAdvice() {
        // here we have the advice for the first pointcut of this class (method transactionAnnotationPointcut)
        System.out.println("Before - transactionAnnotationPointcut");
    }

    @Before("blsPackagePointcut()")
    public void beforeBlsPackageAdvice() {
        System.out.println("Before - blsPackagePointcut");
    }

    @Before("securedClassPointcut()")
    public void beforeSecuredClassAdvice() {
        System.out.println("Before - securedClassPointcut");
    }

    @Around("getExchangeRateMethodPointcut()")
    public Object aroundSecuredClassAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            System.out.println("Before - getExchangeRateMethodPointcut");
            return proceedingJoinPoint.proceed();
        } finally {
            System.out.println("After - getExchangeRateMethodPointcut");
        }
    }

    @After("namedBeanPointcut()")
    public void afterNamedBeanAdvice() {
        System.out.println("After - namedBeanPointcut");
    }

    @After("stringsAndIntegerArgumentsMethodPointcut()")
    public void afterStringsAndIntegerArgumentsMethodAdvice() {
        System.out.println("After - stringsAndIntegerArgumentsMethodPointcut");
    }

    @After("validatedArgumentPointcut()")
    public void afterValidatedArgumentAdvice() {
        System.out.println("After - validatedArgumentPointcut");
    }

    @After("currencyServiceTargetPointcut()")
    public void afterCurrencyServiceTargetAdvice() {
        System.out.println("After - currencyServiceTargetPointcut");
    }

    @After("currencyServiceSecuredTargetPointcut()")
    public void afterCurrencyServiceSecuredTargetAdvice() {
        System.out.println("After - currencyServiceSecuredTargetPointcut");
    }

    @After("currencyServiceThisPointcut()")
    public void afterCurrencyServiceThisAdvice() {
        System.out.println("After - currencyServiceThisPointcut");
    }

    @After("blsPackageAndInTransactionPointcut()")
    public void afterBlsPackageAndInTransactionAdvice() {
        System.out.println("After - blsPackageAndInTransactionPointcut");
    }

    @AfterThrowing(value = "execution(* module02.question02.bls.CurrencyService.getCurrencyCountryName(..))", throwing = "exception")
    public void afterThrowingException(Exception exception) {
        System.out.println("Exception was thrown from getCurrencyCountryName: " + exception.getClass().getSimpleName());
    }

    @AfterReturning(value = "execution(* module02.question02.bls.CurrencyService.getCurrencyCountryName(..))", returning = "value")
    public void afterThrowingException(String value) {
        System.out.println("Value returned from getCurrencyCountryName: " + value);
    }
}
package module02.question01.with.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.logging.Logger;

// ASPECT
@Aspect
@Component
public class PerformanceLoggerAspect {

    private final Logger logger = Logger.getLogger("performance.logger");

    // POINTCUT EXPRESSION
    @Around("@annotation(module02.question01.with.aop.annotations.PerformanceLogger)")
    public Object logPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // ADVICE
        long startTime = System.currentTimeMillis();
        try {
            logger.info("Logging around " + proceedingJoinPoint.getSignature().getName());
            return proceedingJoinPoint.proceed();
        } finally {
            long finishTime = System.currentTimeMillis();
            Duration duration = Duration.ofMillis(finishTime - startTime);

            logger.info(String.format("Duration of %s execution was %s", proceedingJoinPoint.getSignature().getName(), duration));
        }
    }
}

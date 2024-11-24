package module02.question01.with.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

// --> ASPECT
@Aspect
@Component
public class CacheableAspect {

    private final Logger logger = Logger.getLogger("cache.logger");

    private final Map<CacheKey, Object> cacheMap = new HashMap<>();

    // --> POINTCUT EXPRESSION
    @Around("@annotation(module02.question01.with.aop.annotations.Cacheable)")
    public Object checkCache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // --> ADVICE
        CacheKey cacheKey = new CacheKey(proceedingJoinPoint);

        if (cacheMap.containsKey(cacheKey)) {
            logger.info("Report fetched from the cache " + proceedingJoinPoint.getSignature().toShortString());
            return cacheMap.get(cacheKey);
        } else {
            Object result = proceedingJoinPoint.proceed();
            cacheMap.put(cacheKey, result);
            return result;
        }
    }

    private static class CacheKey {

        private final Object target;

        private final String signature;

        private final Object[] args;

        public CacheKey(ProceedingJoinPoint proceedingJoinPoint) {
            target = proceedingJoinPoint.getTarget();
            signature = proceedingJoinPoint.getSignature().toLongString();
            args = proceedingJoinPoint.getArgs();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CacheKey cacheKey)) return false;
            return target == cacheKey.target &&
                    Objects.equals(signature, cacheKey.signature) &&
                    Arrays.equals(args, cacheKey.args);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(target, signature);
            result = 31 * result + Arrays.hashCode(args);
            return result;
        }
    }
}

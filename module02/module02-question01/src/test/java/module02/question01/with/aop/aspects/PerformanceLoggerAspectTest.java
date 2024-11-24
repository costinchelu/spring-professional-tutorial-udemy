package module02.question01.with.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class PerformanceLoggerAspectTest {

    PerformanceLoggerAspect aspect = new PerformanceLoggerAspect();

    ProceedingJoinPoint joinPoint = mock(ProceedingJoinPoint.class);
    Signature signature = mock(Signature.class);

    @Test
    void testAspect() throws Throwable {

        when(joinPoint.getSignature()).thenReturn(signature);
        when(signature.getName()).thenReturn("save");

        aspect.logPerformance(joinPoint);

        verify(joinPoint, times(2)).getSignature();
        verify(signature, times(2)).getName();
    }
}
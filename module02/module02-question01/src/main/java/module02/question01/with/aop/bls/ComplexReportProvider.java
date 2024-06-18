package module02.question01.with.aop.bls;

import module02.question01.with.aop.annotations.Cacheable;
import module02.question01.with.aop.annotations.PerformanceLogger;
import module02.question01.with.aop.ds.Report;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportProvider {

    // JOINTPOINT
    @PerformanceLogger
    @Cacheable
    public Report getReport() throws InterruptedException {
        System.out.println("Fetching the report...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        System.out.println("Report created");
        return new Report();
    }
}

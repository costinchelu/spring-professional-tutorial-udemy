package module02.question01.with.aop.bls;

import module02.question01.with.aop.annotations.PerformanceLogger;
import module02.question01.with.aop.ds.FormattedReport;
import module02.question01.with.aop.ds.Report;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportFormatter {

    // JOINTPOINT
    @PerformanceLogger
    public FormattedReport formatReport(Report report) throws InterruptedException {
        System.out.println("Formatting the report...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("Report Formatted");
        return new FormattedReport(report);
    }
}

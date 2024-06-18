package module02.question01.no.aop.actions;

import module02.question01.no.aop.bls.ComplexReportFormatter;
import module02.question01.no.aop.bls.ComplexReportProvider;
import module02.question01.no.aop.bls.ComplexReportRepository;
import module02.question01.no.aop.ds.FormattedReport;
import module02.question01.no.aop.ds.Report;
import module02.question01.no.aop.logger.PerformanceLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComplexReportAction {

    @Autowired
    private ComplexReportProvider complexReportProvider;

    @Autowired
    private ComplexReportFormatter complexReportFormatter;

    @Autowired
    private ComplexReportRepository complexReportRepository;

    // performance logging - cross cutting concern
    @Autowired
    private PerformanceLogger performanceLogger;

    public void perform() throws InterruptedException {
        PerformanceLogger.PerformanceLoggerInfo performanceLoggerInfo;

        // each action must be logged - repeating logging. Is there a more clean way to do it?

        // fetch report
        performanceLoggerInfo = performanceLogger.start("complexReportProvider.getReport()");
        Report report = complexReportProvider.getReport();
        performanceLogger.stop(performanceLoggerInfo);

        // format report
        performanceLoggerInfo = performanceLogger.start("complexReportFormatter.formatReport(...)");
        FormattedReport formattedReport = complexReportFormatter.formatReport(report);
        performanceLogger.stop(performanceLoggerInfo);

        // save report
        performanceLoggerInfo = performanceLogger.start("complexReportRepository.save(...)");
        complexReportRepository.save(formattedReport);
        performanceLogger.stop(performanceLoggerInfo);

        // fetch report
        performanceLoggerInfo = performanceLogger.start("complexReportProvider.getReport()");
        report = complexReportProvider.getReport();
        performanceLogger.stop(performanceLoggerInfo);
    }
}
/*
Typical cross-cutting concerns:
    - logging
    - performance logging
    - caching
    - security
    - transactions
    - monitoring
 */
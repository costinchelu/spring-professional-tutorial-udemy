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

    private ComplexReportProvider complexReportProvider;

    private ComplexReportFormatter complexReportFormatter;

    private ComplexReportRepository complexReportRepository;

    private PerformanceLogger performanceLogger;        // performance logging - cross cutting concern

    public ComplexReportAction(ComplexReportProvider provider,
                               ComplexReportFormatter formatter,
                               ComplexReportRepository repository,
                               PerformanceLogger logger) {
        this.complexReportProvider = provider;
        this.complexReportFormatter = formatter;
        this.complexReportRepository = repository;
        this.performanceLogger = logger;
    }

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
package module02.question01.with.aop.actions;

import module02.question01.with.aop.bls.ComplexReportFormatter;
import module02.question01.with.aop.bls.ComplexReportProvider;
import module02.question01.with.aop.bls.ComplexReportRepository;
import module02.question01.with.aop.ds.FormattedReport;
import module02.question01.with.aop.ds.Report;
import org.springframework.stereotype.Component;

@Component
public class ComplexReportAction {

    private final ComplexReportProvider complexReportProvider;

    private final ComplexReportFormatter complexReportFormatter;

    private final ComplexReportRepository complexReportRepository;

    public ComplexReportAction(ComplexReportProvider complexReportProvider,
                               ComplexReportFormatter complexReportFormatter,
                               ComplexReportRepository complexReportRepository) {
        this.complexReportProvider = complexReportProvider;
        this.complexReportFormatter = complexReportFormatter;
        this.complexReportRepository = complexReportRepository;
    }

    public void perform() throws InterruptedException {
        Report report = complexReportProvider.getReport();
        FormattedReport formattedReport = complexReportFormatter.formatReport(report);
        complexReportRepository.save(formattedReport);
        report = complexReportProvider.getReport();
    }
}

package module02.question01.with.aop.actions;

import module02.question01.with.aop.bls.ComplexReportFormatter;
import module02.question01.with.aop.bls.ComplexReportProvider;
import module02.question01.with.aop.bls.ComplexReportRepository;
import module02.question01.with.aop.ds.FormattedReport;
import module02.question01.with.aop.ds.Report;
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

    public void perform() throws InterruptedException {
        Report report = complexReportProvider.getReport();
        FormattedReport formattedReport = complexReportFormatter.formatReport(report);
        complexReportRepository.save(formattedReport);
        report = complexReportProvider.getReport();
    }
}

package module01.question03.service;

import module01.question03.dao.FinancialDataDao;
import module01.question03.ds.FinancialMonthSummary;
import module01.question03.ds.FinancialQuarterSummary;
import module01.question03.ds.FinancialYearSummary;
import module01.question03.writer.FinancialReportWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FinancialReportService {

    private final FinancialDataDao financialDataDao;

    private final FinancialReportWriter financialReportWriter;

    public FinancialReportService(@Qualifier("database-dao") FinancialDataDao financialDataDao,
                                  @Qualifier("file-writer") FinancialReportWriter financialReportWriter) {
        this.financialDataDao = financialDataDao;
        this.financialReportWriter = financialReportWriter;
    }

    public void generateReport() {
        FinancialYearSummary financialYearSummary = financialDataDao.findFinancialYearSummary(2019);
        FinancialQuarterSummary financialQuarterSummary = financialDataDao.findFinancialQuarterSummary(2019, 1);
        FinancialMonthSummary financialMonthSummary = financialDataDao.findFinancialMonthSummary(2019, 4);

        financialReportWriter.appendFreeText("Year / Quarter / Month Financial Report");
        financialReportWriter.appendFinancialYearSummary(financialYearSummary);
        financialReportWriter.appendFinancialQuarterSummary(financialQuarterSummary);
        financialReportWriter.appendFinancialMonthSummary(financialMonthSummary);
    }
}

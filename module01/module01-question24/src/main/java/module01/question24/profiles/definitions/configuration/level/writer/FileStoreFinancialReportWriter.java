package module01.question24.profiles.definitions.configuration.level.writer;

import module01.question24.profiles.definitions.configuration.level.ds.FinancialMonthSummary;
import module01.question24.profiles.definitions.configuration.level.ds.FinancialQuarterSummary;
import module01.question24.profiles.definitions.configuration.level.ds.FinancialYearSummary;

public class FileStoreFinancialReportWriter implements FinancialReportWriter {

    @Override
    public void appendFreeText(String title) {
        System.out.println("File Writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearSummary financialYearSummary) {
        System.out.println("File Writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary) {
        System.out.println("File Writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("File Writer => appendFinancialMonthSummary");
    }
}

package module01.question24.profiles.definitions.custom.annotation.dao;

import module01.question24.profiles.definitions.custom.annotation.ds.FinancialMonthSummary;
import module01.question24.profiles.definitions.custom.annotation.ds.FinancialQuarterSummary;
import module01.question24.profiles.definitions.custom.annotation.ds.FinancialYearSummary;

public interface FinancialDataDao {

    FinancialYearSummary findFinancialYearSummary(int year);

    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
}

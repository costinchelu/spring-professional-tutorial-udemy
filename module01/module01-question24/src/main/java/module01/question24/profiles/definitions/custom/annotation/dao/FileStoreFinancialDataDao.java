package module01.question24.profiles.definitions.custom.annotation.dao;

import module01.question24.profiles.definitions.custom.annotation.annotations.FileProfile;
import module01.question24.profiles.definitions.custom.annotation.ds.FinancialMonthSummary;
import module01.question24.profiles.definitions.custom.annotation.ds.FinancialQuarterSummary;
import module01.question24.profiles.definitions.custom.annotation.ds.FinancialYearSummary;
import org.springframework.stereotype.Component;

@Component
@FileProfile
class FileStoreFinancialDataDao implements FinancialDataDao {

    @Override
    public FinancialYearSummary findFinancialYearSummary(int year) {
        System.out.println("File Dao => findFinancialYearSummary");
        return new FinancialYearSummary();
    }

    @Override
    public FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter) {
        System.out.println("File Dao => findFinancialQuarterSummary");
        return new FinancialQuarterSummary();
    }

    @Override
    public FinancialMonthSummary findFinancialMonthSummary(int year, int month) {
        System.out.println("File Dao => findFinancialMonthSummary");
        return new FinancialMonthSummary();
    }
}

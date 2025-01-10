package module02.question04.service.a;

import module02.question04.ds.Employee;
import org.springframework.stereotype.Component;

// If the class is final, then CGLIB proxy cannot be used
@Component
public /*final*/ class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public Employee findEmployeeById(long id) {
        return new Employee();
    }

    @Override
    public void saveEmployee(Employee employee) {
    }

    @Override
    public /*final*/ void deleteEmployee(Employee employee) {
    }

    @Override
    public void findAndUpdateEmployeeById(long id, Employee employeeToMerge) {
        // self invocation
        Employee employeeById = findEmployeeById(id);
        saveEmployee(employeeById);
    }

    // this method is not part of the interface so the CGLIB proxy will not have access to it
    public void deleteByEmail(String email) {

    }
}

package module02.question03.service.a;

import module02.question03.ds.Employee;

public interface EmployeeRepository {

    Employee findEmployeeById(long id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}

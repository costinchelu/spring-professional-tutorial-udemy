package module02.question03.proxyexample;

import module02.question03.ds.Employee;
import module02.question03.service.b.AlternateEmployeeRepository;

// This is a proxy similar to how AOP would implement a (CGLIB) proxy to be used instead of the actual implementation (in case the advised class doesn't implement an interface
public class EmployeeRepositoryCglibProxy extends AlternateEmployeeRepository {

    @Override
    public Employee findEmployeeById(long id) {
        System.out.println("BEFORE findEmployeeById");
        Employee employee = super.findEmployeeById(id);
        System.out.println("AFTER findEmployeeById");
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        System.out.println("BEFORE saveEmployee");
        super.saveEmployee(employee);
        System.out.println("AFTER saveEmployee");
    }

    @Override
    public void deleteEmployee(Employee employee) {
        System.out.println("BEFORE deleteEmployee");
        super.deleteEmployee(employee);
        System.out.println("AFTER deleteEmployee");
    }
}

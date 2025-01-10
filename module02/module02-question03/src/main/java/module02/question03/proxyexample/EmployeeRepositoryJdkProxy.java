package module02.question03.proxyexample;


import module02.question03.ds.Employee;
import module02.question03.service.a.EmployeeRepository;
import module02.question03.service.a.EmployeeRepositoryImpl;

// This is a proxy similar to how AOP would implement a (JDK) proxy to be used instead of the actual implementation
public class EmployeeRepositoryJdkProxy implements EmployeeRepository {

    private final EmployeeRepositoryImpl employeeRepositoryImpl;

    public EmployeeRepositoryJdkProxy(EmployeeRepositoryImpl employeeRepositoryImpl) {
        this.employeeRepositoryImpl = employeeRepositoryImpl;
    }

    @Override
    public Employee findEmployeeById(long id) {
        System.out.println("BEFORE - findEmployeeById");
        Employee employee = employeeRepositoryImpl.findEmployeeById(id);
        System.out.println("AFTER - findEmployeeById");
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        System.out.println("BEFORE - saveEmployee");
        employeeRepositoryImpl.saveEmployee(employee);
        System.out.println("AFTER - saveEmployee");
    }

    @Override
    public void deleteEmployee(Employee employee) {
        System.out.println("BEFORE - deleteEmployee");
        employeeRepositoryImpl.deleteEmployee(employee);
        System.out.println("AFTER - deleteEmployee");
    }
}

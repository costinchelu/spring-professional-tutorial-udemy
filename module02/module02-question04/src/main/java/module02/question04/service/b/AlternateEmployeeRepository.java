package module02.question04.service.b;

import module02.question04.ds.Employee;
import org.springframework.stereotype.Component;

// If the class is final, then CGLIB proxy cannot be used (cannot extend the class)
// only public/protected and package methods will be proxied (no private) with CGLIB proxy
// for JDK dynamic proxy, only the public methods can be proxied
@Component
public /*final*/ class AlternateEmployeeRepository {

    public Employee findEmployeeById(long id) {
        return new Employee();
    }

    public void saveEmployee(Employee employee) {
    }

    // final methods cannot be proxied with a CGLIB proxy (cannot extend the method
    public /*final*/ void deleteEmployee(Employee employee) {
    }

    public void findAndUpdateEmployeeById(long id, Employee employeeToMerge) {
        // self invocation
        Employee employeeById = findEmployeeById(id);
        saveEmployee(employeeById);
    }
}

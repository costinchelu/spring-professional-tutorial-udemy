package module02.question04;

import module02.question04.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class SamePackageEmployeeRepository {

    public void saveEmployee(Employee employee) {
    }

    protected void deleteEmployee(long id) {
    }

    void deleteEmployeeByEmail(String email) {
    }

    // being private, the method will not
    private void deleteEmployeeByPhone(String phone) {
        System.out.println("deleteEmployeeByPhone method called");
    }
}

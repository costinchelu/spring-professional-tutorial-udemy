package module02.question07.beans;

import module02.question07.annotation.MonitoredRepository;
import module02.question07.ds.Department;
import org.springframework.stereotype.Component;

@Component
@MonitoredRepository
public class DepartmentRepository {

    public Department findDepartment(String pattern) {
        return new Department();
    }

    public void updateDepartment(int id, Department department) {
    }
}

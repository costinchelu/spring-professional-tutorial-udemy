package module01.question19.dao;

import module01.question19.ds.Department;

public class DepartmentDao {

    public Department findById(int id) {
        System.out.println("Searching for department...");
        return new Department();
    }

    public void save(Department department) {
        System.out.println("Saving department...");
    }
}

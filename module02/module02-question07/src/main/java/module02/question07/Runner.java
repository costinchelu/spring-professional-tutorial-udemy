package module02.question07;

import module02.question07.beans.DepartmentRepository;
import module02.question07.beans.EmployeeBean;
import module02.question07.beans.HelloChildBean;
import module02.question07.beans.ITaxBean;
import module02.question07.beans.TaxBean2;
import module02.question07.ds.Department;
import module02.question07.ds.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        System.out.println("--> HelloChildBean <--");
        HelloChildBean springBean = context.getBean(HelloChildBean.class);
        springBean.sayHello("John", 5);
        springBean.validateName("Jane");
        springBean.saveCounterValue(7);
        springBean.savePerson(new Person());

        System.out.println("--> TaxBean <--");
        ITaxBean taxBean1 = context.getBean(ITaxBean.class);
        TaxBean2 taxBean2 = context.getBean(TaxBean2.class);
        taxBean1.calculateTax(5f);
        taxBean2.calculateTax(10f);

        System.out.println("--> DepartmentBean <--");
        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
        Department department = departmentRepository.findDepartment("DEPA%");
        departmentRepository.updateDepartment(5, department);

        System.out.println("--> EmployeeBean <--");
        EmployeeBean employeeBean = context.getBean(EmployeeBean.class);
        employeeBean.setId(5);
        employeeBean.setCubicId("A-105");
        employeeBean.setName("John");
        employeeBean.setWorkPhone("18885555");
        int id = employeeBean.getId();
        String cubicId = employeeBean.getCubicId();
        String name = employeeBean.getName();
        String workPhone = employeeBean.getWorkPhone();
    }
}

package module02.question04;

import module02.question04.ds.Employee;
import module02.question04.service.a.EmployeeRepository;
import module02.question04.service.b.AlternateEmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        AlternateEmployeeRepository alternateEmployeeRepository = context.getBean(AlternateEmployeeRepository.class);
        SamePackageEmployeeRepository samePackageEmployeeRepository = context.getBean(SamePackageEmployeeRepository.class);

        // doesn't support self invocation - because of that we will only get the advice for the findAndUpdateEmployeeById and not for
        // findEmployeeById(id) & saveEmployee(employeeById) that are called inside this method
        employeeRepository.findAndUpdateEmployeeById(5, new Employee());

//        employeeRepository.findEmployeeById(5);
//        employeeRepository.saveEmployee(new Employee());
//        employeeRepository.deleteEmployee(new Employee());

        // only by using the reflection can execute deleteByEmail that is not part of the EmployeeRepository interface
        // still the proxy will not contain the method, and we will get an exception when we try the call to deleteByEmail
//        Method deleteByEmail = employeeRepository.getClass().getDeclaredMethod("deleteByEmail", String.class);
//        deleteByEmail.setAccessible(true);
//        deleteByEmail.invoke(samePackageEmployeeRepository, "john@corp.net");

        alternateEmployeeRepository.findAndUpdateEmployeeById(5, new Employee());
        alternateEmployeeRepository.findEmployeeById(5);
        alternateEmployeeRepository.saveEmployee(new Employee());
        alternateEmployeeRepository.deleteEmployee(new Employee());

        samePackageEmployeeRepository.saveEmployee(new Employee());
        samePackageEmployeeRepository.deleteEmployee(5);
        samePackageEmployeeRepository.deleteEmployeeByEmail("john@corp.net");

        //Method deleteEmployeeByPhone = samePackageEmployeeRepository.getClass().getSuperclass().getDeclaredMethod("deleteEmployeeByPhone", String.class);
        //deleteEmployeeByPhone.setAccessible(true);
        //deleteEmployeeByPhone.invoke(samePackageEmployeeRepository, "202-555-0140");
    }
}

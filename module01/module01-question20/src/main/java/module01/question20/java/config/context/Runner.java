package module01.question20.java.config.context;

import module01.question20.java.config.context.beans.SpringBean1;
import module01.question20.java.config.context.beans.SpringBean3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        springBean1.printDependencies();

        SpringBean3 springBean3 = context.getBean(SpringBean3.class);
        springBean3.printHash();
    }
}

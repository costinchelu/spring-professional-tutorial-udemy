package module01.question06.non.web;

import module01.question06.non.web.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigAppContextEx2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("module01.question06.non.web.beans");

        SpringBean1 bean = context.getBean(SpringBean1.class);

        bean.sayHello();
    }
}

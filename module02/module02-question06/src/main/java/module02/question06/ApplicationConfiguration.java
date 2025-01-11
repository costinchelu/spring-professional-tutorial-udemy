package module02.question06;

import module02.question06.aspect.HelloBeanAspect;
import module02.question06.beans.HelloBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 1. to enable AOP in Spring we need the spring aop dependency in the classpath (pom.xml, gradle etc) - here spring-aspects is used
// 2. define the beans in the application configuration class, or use @ComponentScan and then annotate the classes with @Component
// 3. we need the @EnableAspectJAutoProxy annotation
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ApplicationConfiguration {
/*
    @Bean
    public HelloBeanAspect helloBeanAspect() {
        return new HelloBeanAspect();
    }

    @Bean
    public HelloBean helloBean() {
        return new HelloBean();
    }
 */
}

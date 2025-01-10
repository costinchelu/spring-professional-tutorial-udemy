package module02.question03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


// it is possible to force Spring to use CGLIB Proxy:
//@EnableAspectJAutoProxy(proxyTargetClass = true)

// for classes implementing an interface, AOP is using a JDK Proxy

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ApplicationConfiguration {
}

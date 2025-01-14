package module02.question07.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TaxBeanAspect {

    @Before("this(module02.question07.beans.ITaxBean)")
    public void thisTaxBean1Example1() {
        System.out.println("Before - thisTaxBean1Example1");
    }

    @Before("this(module02.question07.beans.TaxBean1)")
    public void thisTaxBean1Example2() {
        System.out.println("Before - thisTaxBean1Example2");
        // in this case the "this" is referring to the jdkProxy that is actually of type ITaxBean
        // because it is not of the TaxBean1, this advice will not run
    }

    @Before("target(module02.question07.beans.ITaxBean)")
    public void targetTaxBean1Example1() {
        System.out.println("Before - targetTaxBean1Example1");
        // the target is the original proxied class
        // the original class is TaxBean1 and this class is of type ITaxBean. In this case the advice will run
    }

    @Before("target(module02.question07.beans.TaxBean1)")
    public void targetTaxBean1Example2() {
        System.out.println("Before - targetTaxBean1Example2");
    }

    @Before("this(module02.question07.beans.TaxBean2)")
    public void thisTaxBean2Example() {
        System.out.println("Before - thisTaxBean2Example");
        // this is referring to the cglib proxy, and the proxy extends the proxied class (TaxBean2)
    }

    @Before("target(module02.question07.beans.TaxBean2)")
    public void targetTaxBean2Example() {
        System.out.println("Before - targetTaxBean2Example");
        // target is referring to the cglib proxied class which is of the TaxBean2 type (the actual class)
    }
}

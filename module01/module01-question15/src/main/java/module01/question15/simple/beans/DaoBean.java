package module01.question15.simple.beans;

import org.springframework.stereotype.Repository;

@Repository
public class DaoBean {

    public DaoBean() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }
}

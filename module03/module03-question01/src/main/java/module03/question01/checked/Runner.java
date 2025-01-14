package module03.question01.checked;

import module03.question01.checked.dao.PersonDao;
import module03.question01.checked.ds.Person;
import module03.question01.checked.exception.DaoFilesystemException;
import module03.question01.checked.exception.PersonInvalidException;
import module03.question01.checked.exception.PersonStoreException;

public class Runner {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person = new Person();

        try {
            personDao.save(person);
        } catch (PersonInvalidException e) {
            // handle exception
        } catch (PersonStoreException e) {
            // handle exception
        } catch (DaoFilesystemException e) {
            // handle exception
        }
    }
}

package module03.question01.checked.dao;

import module03.question01.checked.ds.Person;
import module03.question01.checked.exception.DaoFilesystemException;
import module03.question01.checked.exception.PersonInvalidException;
import module03.question01.checked.exception.PersonStoreException;

public class PersonDao {
    public void save(Person person) throws PersonInvalidException, PersonStoreException, DaoFilesystemException {
        if (!valid(person))
            throw new PersonInvalidException();

        if (!filesystemActive(person))
            throw new DaoFilesystemException();

        if (!store(person))
            throw new PersonStoreException();
    }

    private boolean valid(Person person) {
        return false;
    }

    private boolean store(Person person) {
        return false;
    }

    private boolean filesystemActive(Person person) {
        return false;
    }
}

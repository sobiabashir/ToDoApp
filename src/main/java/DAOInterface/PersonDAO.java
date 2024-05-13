package DAOInterface;

import java.util.Collection;
import java.util.List;

public interface PersonDAO<T> {
    void persist(T object);
    T findById(int id);
    List<T> findByFirstName(String firstName);
    List<T> findByLastName(String lastName);
    List<T> findAll();
    void remove(T object);
}
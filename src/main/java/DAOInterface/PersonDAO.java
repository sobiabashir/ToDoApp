package DAOInterface;

import java.util.Collection;
import java.util.List;

public interface PersonDAO<T> {
    void persist(T object);
    T findById(int id);
    T findByEmail(String email);
    List<T> findAll();
    void remove(T object);
}
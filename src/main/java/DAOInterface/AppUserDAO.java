package DAOInterface;


import java.util.Collection;
import java.util.List;

public interface AppUserDAO<T> {
    void persist(T object);
    List<T> findByUsername(String username);
    Collection<T> findAll();
    void remove(T object);
}
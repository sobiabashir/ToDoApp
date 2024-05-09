package DAOInterface;

import com.test.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO<T> {
    void persist(T object);
    T findById(int id);
    Collection<T> findAll();
    Collection<T> findAllByDoneStatus(boolean status);
    Collection<T> findByTitleContains(String keyword);
    Collection<T> findByPersonId(int personId);
    Collection<T> findByDeadlineBefore(LocalDate deadline);
    Collection<T> findByDeadlineAfter(LocalDate deadline);
    void remove(T object);

}

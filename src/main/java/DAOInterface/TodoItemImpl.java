package DAOInterface;

import Sequencer.TodoItemSequencer;
import com.test.Person;
import com.test.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class TodoItemImpl implements TodoItemDAO<TodoItem> {
    Collection<TodoItem> todoItems;
    private static TodoItemImpl instance;

    private TodoItemImpl() {
        todoItems = new ArrayList<>();
    }
    public static TodoItemImpl getInstance() {
        if (instance == null) {
            instance = new TodoItemImpl();
        }
        return instance;
    }
    @Override
    public void persist(TodoItem todoItem) {
        todoItem.setTodoId(TodoItemSequencer.nextId());
        todoItems.add(todoItem);
    }

    @Override
    public TodoItem findById(int id) {
        if (id<0) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        TodoItem todoItem = todoItems.stream()
                .filter(u -> u.getTodoId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No todoItem with id " + id));
           return todoItem;
    }
    @Override
    public Collection<TodoItem> findAll() {
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        if(title== null || title.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        return todoItems.stream()
                .filter(todo -> todo.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
    @Override
    public Collection<TodoItem>findAllByDoneStatus(boolean done) {
        return todoItems.stream()
                .filter(todo -> todo.isCompleted() == done)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        return todoItems.stream()
                .filter(todo -> todo.getCreatedBy().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate deadline){


        if (deadline == null)throw new IllegalArgumentException("Deadline cannot be null");

        return todoItems.stream()
                .filter(todo -> todo.getDeadline().isBefore(deadline))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate deadline) {


        if (deadline ==null)throw new IllegalArgumentException("Deadline cannot be null");
        Collection<TodoItem> todo = todoItems.stream()
                .filter(todos -> todos.getDeadline().isAfter(deadline))
                .collect(Collectors.toList());
             todo.forEach(System.out::println);

        return todo;
    }

    @Override
    public void remove(TodoItem todoItem) {
        if (todoItem == null) {
            throw new IllegalArgumentException("item cannot be null");
        }
        todoItems.removeIf(u -> u.getTodoId() == todoItem.getTodoId());
        if(todoItems.size()==0) {
            System.out.println("No task in the list");
            return;
        }
    }


}

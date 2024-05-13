package DAOInterface;

import com.test.Person;
import com.test.TodoItem;
import db.MySQLConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemImpl implements TodoItemDAO<TodoItem> {
    Collection<TodoItem> todoItems;
    private final Connection connection;
    private static TodoItemImpl instance;

    private static final String INSERT_TODO = "INSERT INTO todo_item (title, description, deadline, done, assignee_id) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM todo_item";
    private static final String SELECT_BY_ID = "SELECT * FROM todo_item WHERE todo_id = ?";
    private static final String SELECT_BY_TITLE = "SELECT * FROM todo_item WHERE title LIKE ?";
    private static final String SELECT_BY_DONE_STATUS = "SELECT * FROM todo_item WHERE done = ?";
    private static final String SELECT_BY_ASSIGNEE_ID = "SELECT * FROM todo_item WHERE assignee_id = ?";
    private static final String SELECT_BY_DEADLINE_BEFORE = "SELECT * FROM todo_item WHERE deadline < ?";
    private static final String SELECT_BY_DEADLINE_AFTER = "SELECT * FROM todo_item WHERE deadline > ?";
    private static final String DELETE_TODO = "DELETE FROM todo_item WHERE todo_id = ?";


    private TodoItemImpl() {
        this.connection = MySQLConnection.getConnection();
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
        try (PreparedStatement statement = connection.prepareStatement(INSERT_TODO, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, todoItem.getTitle());
            statement.setString(2, todoItem.getDescription());
            statement.setDate(3, Date.valueOf(todoItem.getDeadline()));
            statement.setBoolean(4, todoItem.isCompleted());
            statement.setInt(5, todoItem.getAssigneeId());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                int generatedId = resultSet.getInt(1);
                todoItem.setTodoId(generatedId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TodoItem findById(int id) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createTodoItemFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        List<TodoItem> todoItems = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                todoItems.add(createTodoItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }
    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        List<TodoItem> todoItems = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_TITLE)) {
            statement.setString(1, "%" + title + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                todoItems.add(createTodoItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }
    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        List<TodoItem> todoItems = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_DONE_STATUS)) {
            statement.setBoolean(1, done);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                todoItems.add(createTodoItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }
    @Override
    public Collection<TodoItem> findByAssigneeId(int personId) {
        List<TodoItem> todoItems = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ASSIGNEE_ID)) {
            statement.setInt(1, personId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                todoItems.add(createTodoItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }
    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate deadline) {
        List<TodoItem> todoItems = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_DEADLINE_BEFORE)) {
            statement.setDate(1, Date.valueOf(deadline));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                todoItems.add(createTodoItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate deadline) {
        List<TodoItem> todoItems = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_DEADLINE_AFTER)) {
            statement.setDate(1, Date.valueOf(deadline));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                todoItems.add(createTodoItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
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

    private TodoItem createTodoItemFromResultSet(ResultSet resultSet) throws SQLException {

        int todoId = resultSet.getInt("todo_id");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        LocalDate deadline = resultSet.getDate("deadline").toLocalDate();
        boolean done = resultSet.getBoolean("done");
        int assigneeId = resultSet.getInt("assignee_id");

        // Fetch the Person object based on assigneeId
        PersonDAOImpl personDAO = PersonDAOImpl.getInstance();
        Person assignee = personDAO.findById(assigneeId);

        return new TodoItem(todoId, title, description, deadline, done, assigneeId);

    }
}

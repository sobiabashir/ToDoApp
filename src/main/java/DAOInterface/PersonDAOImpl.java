package DAOInterface;

import com.test.Person;
import db.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO<Person> {
    private final Connection connection;

    ///////////// Database queries/////////////////////////////////
    private static final String ADD_PERSON = "INSERT INTO person (person_id, first_name, last_name) VALUES (?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM person WHERE person_id = ?";
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM person WHERE first_name = ?";
    private static final String FIND_BY_LAST_NAME = "SELECT * FROM person WHERE last_name = ?";
    private static final String FIND_ALL = "SELECT * FROM person";
    private static final String REMOVE_PERSON = "DELETE FROM person WHERE person_id = ?";

    //////////////////////////////////////////////////////////////

    private static PersonDAOImpl instance;
    private PersonDAOImpl() {
        this.connection = MySQLConnection.getConnection();
    }

    public static PersonDAOImpl getInstance() {
        if (instance == null) {
            instance = new PersonDAOImpl();
        }
        return instance;
    }

    //////////////////////////////////////

    @Override
    public void persist(Person person) {

        try (PreparedStatement statement = connection.prepareStatement(ADD_PERSON)) {
            statement.setInt(1, person.getId());
            statement.setString(2, person.getFirstName());
            statement.setString(3, person.getLastName());
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                people.add(new Person(resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public List<Person> findByFirstName(String firstName) {
        List<Person> people = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_FIRST_NAME)) {
            statement.setString(1, firstName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                people.add(new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }
    @Override
    public List <Person> findByLastName(String lastName) {
        List<Person> people = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_LAST_NAME)) {
            statement.setString(1, lastName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                people.add(new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public Person findById(int id) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Person(resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(Person person) {
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_PERSON)) {
            statement.setInt(1, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package DAOInterface;

import Sequencer.AppUserSequencer;
import com.test.AppUser;
import com.test.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDAOImpl implements PersonDAO<Person> {
    List<Person> persons;
    private static PersonDAOImpl instance ;
    private PersonDAOImpl   () {persons  = new ArrayList<>();}

    public static PersonDAOImpl getInstance() {
        if (instance == null) {
            instance = new PersonDAOImpl();
        }
        return instance;
    }
    @Override
    public void persist(Person person) {
        person.setId(AppUserSequencer.nextId());
        persons.add(person);

    }
    @Override
    public List<Person> findAll() {
        return persons;
    }
    @Override
    public void remove(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        persons.removeIf(u -> u.getId() == person.getId());
        if(persons.size()==0) {
            System.out.println("No person in the list");
            return;
        }
    }
    @Override
    public Person findByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        Person person = persons.stream()
                .findFirst()
                .filter(u -> u.getEmail().equals(email))
                .orElseThrow(() -> new IllegalArgumentException("No person with email: " + email));
        return person;
    }

    @Override
    public Person findById(int id) {
        if (id<0) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        Person person = persons.stream()

                .filter(u -> u.getId()== id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No person with id " + id));
        return person;
    }

}

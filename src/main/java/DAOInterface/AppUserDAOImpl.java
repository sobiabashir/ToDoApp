package DAOInterface;

import java.util.*;

import Sequencer.AppUserSequencer;
import com.test.AppUser;

import java.util.Collection;
import java.util.stream.Collectors;

public class AppUserDAOImpl implements AppUserDAO<AppUser> {
    List<AppUser> users;

    private static AppUserDAOImpl instance ;

    private AppUserDAOImpl() {users  = new ArrayList<>();}

    public static AppUserDAOImpl getInstance() {
        if (instance == null) {
            instance = new AppUserDAOImpl();
        }
        return instance;
    }

    @Override
    public void persist(AppUser user) {
        user.setId(AppUserSequencer.nextId());
        users.add(user);

    }

    @Override
    public List<AppUser> findByUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        return users.stream()
                    .filter(u -> u.getUsername().equalsIgnoreCase(username))

                 .collect(Collectors.toList());



    }
    @Override
    public List<AppUser> findAll() {
        return users;
    }

    @Override
    public void remove(AppUser user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        users.removeIf(u -> u.getId() == user.getId());
        if(users.size()==0) {
            System.out.println("No user in the list");
            return;
        }
    }
}
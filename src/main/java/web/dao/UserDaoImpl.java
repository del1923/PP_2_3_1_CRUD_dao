package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl {
    private List<User> usersList = new ArrayList<>();
    private static int id;

    {
        usersList.add(new User(++id, "Tom", "Doo", 26, "tom@doo.com"));
        usersList.add(new User(++id, "Jon", "Boo", 30, "jon@boo.com"));

    }

    public List<User> getUserList() {
        return usersList;
    }

    public void addUser ( User user) {
        user.setId(++id);
        usersList.add( user );
    }
    public User show ( int id ) {
        return usersList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}

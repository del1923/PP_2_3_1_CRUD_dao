package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl {
    private List<User> usersList = new ArrayList<>();

    {
        usersList.add(new User( 1, "Tom", "Doo", 26, "tom@doo.com"));
        usersList.add(new User(2, "Jon", "Boo", 30, "jon@boo"));

    }

    public List<User> getUserList() {
        return usersList;
    }
}

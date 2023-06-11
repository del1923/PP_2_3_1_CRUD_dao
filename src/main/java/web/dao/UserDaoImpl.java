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
    public void update (int id, User user ) {
        User updateUser = show( id );
        updateUser.setName( user.getName() );
        updateUser.setSurName( user.getSurName() );
        updateUser.setAge( user.getAge() );
        updateUser.seteMail( user.geteMail() );
    }

    public void delete ( int id ) {
        usersList.removeIf( user -> user.getId() == id );
        System.out.println("Удалён пользователь "+ id );
    }
}

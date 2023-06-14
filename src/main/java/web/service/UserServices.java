package web.service;

import web.model.User;

import java.util.List;

public interface UserServices {
    public List<User> getUserList();

    void addUser( User user );

    public User show( int id );

    void update( int id, User user);

    void delete( int id );

}

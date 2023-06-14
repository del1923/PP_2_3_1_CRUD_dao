package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import java.util.List;
@Component
public class UserServicesImpl implements UserServices {

    private UserDao userDao;
    @Autowired
    public UserServicesImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    @Transactional
    public void addUser ( User user) {
        userDao.addUser( user );
    }

    @Override
    @Transactional
    public User show ( int id ) {
        return userDao.show( id );
    }

    @Override
    @Transactional
    public void update (int id, User user ) {
        userDao.update( id, user );
    }
    @Override
    @Transactional
    public void delete ( int id ) {
        userDao.delete( id );
    }
}

package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import java.util.List;
import java.util.Optional;

@Component
public class UserServicesImpl implements UserServices {

    private final UserDao userDao;
    @Autowired
    public UserServicesImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional( readOnly = true )
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    @Transactional
    public void addUser ( User user) {
        userDao.addUser( user );
    }

    @Override
    @Transactional( readOnly = true )
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

    @Override
    @Transactional( readOnly = true )
    public Optional<User> showByEMail (String eMail ) {
        return userDao.showByEMail( eMail ); } // Возвращаем еМайл из UserServ -> userDao.findByeMail( eMail )
}

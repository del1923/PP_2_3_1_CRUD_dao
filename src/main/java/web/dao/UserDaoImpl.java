package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery( "SELECT users FROM User users", User.class ).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist( user );
    }

    @Override
    public User show ( int id ) {
        return entityManager.find( User.class, id );
    }

    @Override
    public void update (int id, User user ) {
        entityManager.merge( user );
    }

    @Override
    public void delete ( int id ) {
        entityManager.remove( entityManager.find( User.class, id ) );
    }

    @Override
    public Optional<User> showByEMail ( String eMail) {
        TypedQuery<User> tQuery = entityManager.createQuery( "SELECT user FROM User user WHERE user.eMail = :eMail",
                        User.class );
        tQuery.setParameter( "eMail", eMail );
        return tQuery.getResultList().stream().findAny();
    }
}
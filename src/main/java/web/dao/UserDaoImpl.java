package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional( readOnly = true )
    public List<User> getUserList() {
       return entityManager.createQuery( "SELECT users FROM User users", User.class ).getResultList();
    }
    @Transactional()
    public void addUser ( User user) {
            entityManager.persist( user );
    }
    @Transactional ( readOnly = true )
    public User show ( int id ) {
        return entityManager.find( User.class, id );
    }
    @Transactional
    public void update (int id, User user ) {
      User updateUser = entityManager.find( User.class, id );
      updateUser.setName( user.getName() );
      updateUser.setSurName( user.getSurName() );
      updateUser.setAge( user.getAge() );
      updateUser.seteMail( user.geteMail() );
    }
    @Transactional
    public void delete ( int id ) {
        entityManager.remove( entityManager.find( User.class, id ) );
   }
}

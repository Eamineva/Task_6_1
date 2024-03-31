package web.DAO;

import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void add(User user) {
        entityManager.persist(user);

    }

    public void delUser(long id) {
        //entityManager.find(User.class, id);
        entityManager.remove(entityManager.find(User.class, id));

    }

    @Override
    public void updUser(long id, User user) {

//        User user = entityManager.find(User.class, id);
//        if (user != null){
//            user.setName(update);
//        }
        //entityManager.refresh(entityManager.find(User.class, id));
        User userup = show(id);
        userup.setName(user.getName());
        userup.setSurname(user.getSurname());
        userup.setEmail(user.getEmail());
        //entityManager.refresh(entityManager.find(User, id));
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    /*public void updUser(User user) {
        entityManager.persist(user);

    }*/
}

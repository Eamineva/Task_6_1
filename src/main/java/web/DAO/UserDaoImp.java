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

        entityManager.remove(entityManager.find(User.class, id));

    }

    @Override
    public void updUser(long id, User user) {


        User userup = show(id);
        userup.setName(user.getName());
        userup.setSurname(user.getSurname());
        userup.setEmail(user.getEmail());

    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);
    }


}

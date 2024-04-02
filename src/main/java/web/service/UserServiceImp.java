package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
        @Override
    public void add(User user)  {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void updUser(long id, User user)  {
        userDao.updUser(id, user);
    }

    @Transactional
    @Override
    public void delUser(long id)  {
        userDao.delUser(id);
    }
    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public User show(long id) {
        return userDao.show(id);
    }

}

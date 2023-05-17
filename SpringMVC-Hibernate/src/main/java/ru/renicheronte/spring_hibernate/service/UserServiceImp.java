package ru.renicheronte.spring_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.renicheronte.spring_hibernate.dao.UserDao;
import ru.renicheronte.spring_hibernate.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void removeUserById(int id) {
        userDao.removeUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User showUserById(int id) {
        return userDao.showUserById(id);
    }

    @Transactional
    @Override
    public void updateUserById(int id, User user) {
        userDao.updateUserById(id, user);
    }
}

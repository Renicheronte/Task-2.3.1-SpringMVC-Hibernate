package ru.renicheronte.spring_hibernate.dao;

import ru.renicheronte.spring_hibernate.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    void saveUser(User user);
    void removeUserById(int id);
    User showUserById(int id);
    void updateUserById(int id, User user);
}

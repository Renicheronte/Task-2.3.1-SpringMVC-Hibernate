package ru.renicheronte.spring_hibernate.dao;

import org.springframework.stereotype.Repository;
import ru.renicheronte.spring_hibernate.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User showUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUserById(int id, User user) {
        User userToUpdate = showUserById(id);
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setSecondName(user.getSecondName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setBalance(user.getBalance());
        entityManager.merge(userToUpdate);
    }
}

package ru.kata.spring.boot_security.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepositories;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositories userDao;

    @Autowired
    public UserServiceImpl(UserRepositories userDAO) {
        this.userDao = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.findById(id).get();
    }

    @Override
    public void addUser(@Valid User user) {
        userDao.save(user);
    }

    @Override
    public void removeUser(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void updateUser(@Valid User user) {
        userDao.save(user);
    }
}

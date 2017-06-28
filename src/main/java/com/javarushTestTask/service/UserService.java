package com.javarushTestTask.service;

import com.javarushTestTask.dao.UserDAO;
import com.javarushTestTask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    UserDAO userDAO;

    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    public List<User> getUsers(int pageNumber) {
        if (pageNumber < 1) throw new IllegalArgumentException();

        List<User> users = userDAO.getAllUsers();
        int size = users.size();
        int startIndex = (pageNumber - 1) * 5;
        if (startIndex > size)
            return getUsers(1);
        int endIndex = (pageNumber * 5) > size ? size : (pageNumber * 5);
        return users.subList(startIndex, endIndex);
    }

    @Transactional
    public List<User> filterUsersByName(String name) {
        return userDAO.filterUsersByName(name);
    }

    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}

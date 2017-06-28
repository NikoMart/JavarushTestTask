package com.javarushTestTask.dao;

import com.javarushTestTask.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List<User> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("FROM User").list();
        return userList;
    }

    public List<User> filterUsersByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("FROM User where name like '" + name + "%'").list();
        return userList;
    }

    public User getUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        return user;
    }

    public User addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        return user;
    }

    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if (user != null) {
            session.delete(user);
        }
    }

}


package com.javarushTestTask.model;

import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Proxy(lazy = false)
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "isAdmin")
    boolean Admin;

    @Column(name = "createDate")
    Date createDate;


    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = new Date();
    }

    public User(int id, String name, int age, boolean isAdmin, Date createDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.Admin = isAdmin;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        Admin = admin;
    }
}

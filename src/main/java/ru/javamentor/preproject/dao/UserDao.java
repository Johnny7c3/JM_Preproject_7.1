package ru.javamentor.preproject.dao;

import ru.javamentor.preproject.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    User getUserByCar(String model, String series);
}

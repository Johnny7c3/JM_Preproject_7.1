package ru.javamentor.preproject.service;

import ru.javamentor.preproject.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUserByCar(String model, String series);
}

package ru.javamentor.preproject;

import ru.javamentor.preproject.config.AppConfig;
import ru.javamentor.preproject.model.Car;
import ru.javamentor.preproject.model.User;
import ru.javamentor.preproject.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Audi", "A8");
        Car car2 = new Car("BMW", "X5");
        
        User user1 = new User("user1", "lastname1", "user1@mail.ru", car1);
        User user2 = new User("user2", "lastname2", "user2@mail.ru", car2);

        userService.add(user1);
        userService.add(user2);

        List<User> users = userService.listUsers();
        
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.infoCar());
            System.out.println();
        }

        User user = userService.getUserByCar("Audi", "A8");
        
        System.out.println("Id = " + user.getId());
        System.out.println("First Name = " + user.getFirstName());
        System.out.println("Last Name = " + user.getLastName());
        System.out.println("Email = " + user.getEmail());
        System.out.println("Car = " + user.infoCar());
        System.out.println();

        context.close();
    }
}

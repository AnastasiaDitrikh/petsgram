package ru.ditrikh.petsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.ditrikh.petsgram.exceptions.InvalidEmailException;
import ru.ditrikh.petsgram.exceptions.UserAlreadyExistException;
import ru.ditrikh.petsgram.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    private HashMap<String, User> users = new HashMap<>();

    @GetMapping("/users")
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        validateUser(user);
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователь с таким email существует");
        }
        users.put(user.getEmail(), user);
        return user;
    }


    @PutMapping(value = "/users")
    public User update(@RequestBody User user) {
        validateUser(user);
        users.put(user.getEmail(), user);
        return user;
    }

    private void validateUser(User user) {
        if (user.getEmail().isBlank()) {
            throw new InvalidEmailException("Некорректный email адрес пользователя");
        }
    }
}
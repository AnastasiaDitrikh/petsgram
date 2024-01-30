package ru.ditrikh.petsgram.service;

import org.springframework.stereotype.Service;
import ru.ditrikh.petsgram.exceptions.InvalidEmailException;
import ru.ditrikh.petsgram.exceptions.UserAlreadyExistException;
import ru.ditrikh.petsgram.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> users = new HashMap<>();

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User create(User user) {
        validateUser(user);
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователь с таким email существует");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    public User update(User user) {
        validateUser(user);
        users.put(user.getEmail(), user);
        return user;
    }

    public User findUserByEmail(String email){
        return users.getOrDefault(email, null);
    }

    private void validateUser(User user) {
        if (user.getEmail().isBlank()) {
            throw new InvalidEmailException("Некорректный email адрес пользователя");
        }
    }
}

package ru.ditrikh.petsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ditrikh.petsgram.model.User;
import ru.ditrikh.petsgram.service.UserService;

import java.util.List;

/**
 * Класс UserController представляет контроллер REST API для работы с сущностью "Пользователь".
 * Он аннотирован аннотацией @RestController, которая указывает, что класс является контроллером REST API и обрабатывает HTTP-запросы.
 */
@RestController
public class UserController {
    private final UserService userService;

    /**
     * Конструктор контроллера принимает в качестве параметра сервис UserService для выполнения операций над пользователями.
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Обрабатывает GET-запрос к эндпоинту "/users" для получения списка всех пользователей
     *
     * @return список пользователей
     */
    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    /**
     * Обрабатывает POST-запрос к эндпоинту "/users" для создания нового пользователя
     *
     * @param user - пользователь для создания
     * @return - объект User
     */
    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    /**
     * Обрабатывает PUT-запрос к эндпоинту "/users" для обновления существующего пользователя
     *
     * @param user - пользователь для обновления
     * @return - объект User
     */
    @PutMapping(value = "/users")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * Обрабатывает GET-запрос к эндпоинту "/users/{email}" для поиска пользователя по электронной почте
     *
     * @param email - адрес электронной почты
     * @return - объект User
     */
    @GetMapping("/users/{email}")
    public User findUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }
}
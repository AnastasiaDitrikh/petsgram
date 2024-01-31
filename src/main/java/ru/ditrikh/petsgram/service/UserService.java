package ru.ditrikh.petsgram.service;

import org.springframework.stereotype.Service;
import ru.ditrikh.petsgram.exceptions.InvalidEmailException;
import ru.ditrikh.petsgram.exceptions.UserAlreadyExistException;
import ru.ditrikh.petsgram.model.User;

import java.util.*;

/**
 * Класс UserService предоставляет методы для работы с сущностью "Пользователь".
 */
@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    /**
     * Метод findAll возвращает список всех пользователей.
     *
     * @return список всех пользователей
     */
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    /**
     * Метод create создает нового пользователя.
     *
     * @param user создаваемый пользователь
     * @return созданный пользователь
     * @throws UserAlreadyExistException если пользователь с таким email уже существует
     */
    public User create(User user) {
        validateUser(user);
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователь с таким email существует");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    /**
     * Метод update обновляет информацию о существующем пользователе.
     *
     * @param user обновляемый пользователь
     * @return обновленный пользователь
     * @throws InvalidEmailException если email пользователя некорректный
     */
    public User update(User user) {
        validateUser(user);
        users.put(user.getEmail(), user);
        return user;
    }

    /**
     * Метод findUserByEmail возвращает пользователя по его email.
     *
     * @param email электронная почта пользователя
     * @return найденный пользователь или null, если пользователь не найден
     */
    public User findUserByEmail(String email) {
        return users.getOrDefault(email, null);
    }

    /**
     * Приватный вспомогательный метод validateUser выполняет проверку корректности данных пользователя.
     *
     * @param user пользователь для проверки
     * @throws InvalidEmailException если email пользователя некорректный
     */
    private void validateUser(User user) {
        if (user.getEmail().isBlank()) {
            throw new InvalidEmailException("Некорректный email адрес пользователя");
        }
    }
}
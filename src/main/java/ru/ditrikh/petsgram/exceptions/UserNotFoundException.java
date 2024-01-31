package ru.ditrikh.petsgram.exceptions;

/**
 * Класс UserNotFoundException представляет исключение, которое выбрасывается если пользователь не найден.
 * Он наследуется от класса RuntimeException, что означает, что это неконтролируемое исключение и не требует явного обработчика.
 * Конструктор принимает сообщение с описанием ошибки и передает его в конструктор суперкласса RuntimeException.
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
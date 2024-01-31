package ru.ditrikh.petsgram.exceptions;

/**
 * Класс UserAlreadyExistException представляет исключение, которое выбрасывается если пользователь не существует.
 * Он наследуется от класса RuntimeException, что означает, что это неконтролируемое исключение и не требует явного обработчика.
 * Конструктор принимает сообщение с описанием ошибки и передает его в конструктор суперкласса RuntimeException.
 */
public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
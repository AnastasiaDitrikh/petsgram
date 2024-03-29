package ru.ditrikh.petsgram.exceptions;

/**
 * Класс InvalidEmailException представляет исключение, которое выбрасывается при некорректном электронном адресе пользователя.
 * Он наследуется от класса RuntimeException, что означает, что это неконтролируемое исключение и не требует явного обработчика.
 * Конструктор принимает сообщение с описанием ошибки и передает его в конструктор суперкласса RuntimeException.
 */
public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException(String message) {
        super(message);
    }
}
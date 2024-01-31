package ru.ditrikh.petsgram.exceptions;

/**
 * Класс PostNotFoundException представляет исключение, которое выбрасывается если пост не найден.
 * Он наследуется от класса RuntimeException, что означает, что это неконтролируемое исключение и не требует явного обработчика.
 * Конструктор принимает сообщение с описанием ошибки и передает его в конструктор суперкласса RuntimeException.
 */
public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String message) {
        super(message);
    }
}
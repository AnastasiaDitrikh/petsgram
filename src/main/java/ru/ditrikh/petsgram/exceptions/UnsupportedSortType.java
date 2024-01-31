package ru.ditrikh.petsgram.exceptions;

/**
 * Класс UnsupportedSortType представляет исключение, которое выбрасывается если введен неподдерживаемого типа сортировки.
 * Он наследуется от класса RuntimeException, что означает, что это неконтролируемое исключение и не требует явного обработчика.
 * Конструктор принимает сообщение с описанием ошибки и передает его в конструктор суперкласса RuntimeException.
 */
public class UnsupportedSortType extends RuntimeException {

    public UnsupportedSortType(String message) {
        super(message);
    }
}
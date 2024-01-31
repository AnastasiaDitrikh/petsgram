package ru.ditrikh.petsgram.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Класс User представляет объект пользователя в системе.
 * Поля класса:
 * - email: электронная почта пользователя
 * - nickname: никнейм пользователя
 * - birthdate: дата рождения пользователя
 */
@Getter
@Setter
public class User {

    private String email;
    private String nickname;
    private LocalDate birthdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

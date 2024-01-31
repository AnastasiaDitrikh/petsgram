package ru.ditrikh.petsgram.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

/**
 * Класс Post представляет объект поста.
 * Поля класса:
 * - id: идентификатор поста
 * - author: автор поста
 * - creationDate: дата и время создания поста (установлено при создании объекта)
 * - description: описание поста
 * - photoUrl: URL-адрес фотографии, связанной с постом
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Integer id;
    private String author; // автор
    private Instant creationDate = Instant.now(); // дата создания
    private String description; // описание
    private String photoUrl; // url-адрес фотографии

    public Post(Integer id, String author, String description, String photoUrl) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
    }
}
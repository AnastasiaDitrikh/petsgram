package ru.ditrikh.petsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ditrikh.petsgram.exceptions.UnsupportedSortType;
import ru.ditrikh.petsgram.model.Post;
import ru.ditrikh.petsgram.service.PostService;

import java.util.List;

/**
 * Класс PostController представляет контроллер REST API для работы с сущностью "Пост".
 * Он аннотирован аннотацией @RestController, которая указывает, что класс является контроллером REST API и обрабатывает HTTP-запросы.
 */
@RestController
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    /**
     * Конструктор контроллера принимает в качестве параметра сервис PostService для выполнения операций над постами.
     */
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * обрабатывает GET-запрос к эндпоинту "/posts/{postId}" для поиска поста по идентификатору
     *
     * @param postId - идентификатор поста
     * @return объект Post
     */
    @GetMapping("/posts/{postId}")
    public Post findById(@PathVariable Integer postId) {
        return postService.findById(postId);
    }

    /**
     * Обрабатывает GET-запрос к эндпоинту "/posts" для получения списка всех постов с возможностью пагинации и сортировки
     * Если передан некорректный тип сортировки или неверные параметры пагинации, будут сгенерированы исключения UnsupportedSortType и IllegalArgumentException соответственно.
     *
     * @param page - количество страниц
     * @param size - количество постов на одной странице
     * @param sort - принимает значения "asc" или "desc" для сортировки по возрастанию или убыванию
     * @return лист объектов Post
     */
    @GetMapping("/posts")
    public List<Post> findAll(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "10", required = false) Integer size,
            @RequestParam(defaultValue = "desc", required = false) String sort) { // по умолчанию сортировка по убыванию

        if (!(sort.equals("asc") || sort.equals("desc"))) {
            throw new UnsupportedSortType("Данного способа сортировки не существует");
        }

        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Некорректные данные");
        }

        Integer from = page * size;
        return postService.findAll(size, from, sort);
    }

    /**
     * Обрабатывает POST-запрос к эндпоинту "/post" для создания нового поста
     *
     * @param post - объект, который нужно создать
     * @return объект Post
     */
    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }
}
package ru.ditrikh.petsgram.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ditrikh.petsgram.exceptions.PostNotFoundException;
import ru.ditrikh.petsgram.exceptions.UserNotFoundException;
import ru.ditrikh.petsgram.model.Post;
import ru.ditrikh.petsgram.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс PostService предоставляет методы для работы с сущностью "Пост".
 */
@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();

    private final UserService userService;

    private static Integer globalId = 0;


    @Autowired
    public PostService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Метод findAll возвращает список всех постов с возможностью пагинации и сортировки.
     *
     * @param size размер страницы
     * @param from смещение начала списка
     * @param sort порядок сортировки ("asc" - по возрастанию, "desc" - по убыванию)
     * @return список постов
     */
    public List<Post> findAll(Integer size, Integer from, String sort) {
        Comparator<Post> comparator = Comparator.comparing(Post::getCreationDate); //компаратор по возрастанию
        posts.sort(sort.equals("desc") ? Collections.reverseOrder(comparator) : comparator);
        return  posts.subList(from, size);
    }

    /**
     * Метод findById возвращает пост по его идентификатору.
     *
     * @param postId идентификатор поста
     * @return найденный пост
     * @throws PostNotFoundException если пост с заданным идентификатором не найден
     */
    public Post findById(Integer postId) {
        return posts.stream()
                .filter(x -> x.getId().equals(postId))
                .findFirst()
                .orElseThrow(() -> new PostNotFoundException(String.format("Пост с %d не найден", postId)));
    }

    /**
     * Метод create создает новый пост.
     *
     * @param post создаваемый пост
     * @return созданный пост
     * @throws UserNotFoundException если автор поста не найден
     */
    public Post create(Post post) {
        User postAuthor = userService.findUserByEmail(post.getAuthor());
        if (postAuthor == null) {
            throw new UserNotFoundException(String.format(
                    "Пользователь %s не найден",
                    post.getAuthor()));
        }

        post.setId(getNextId());
        posts.add(post);
        return post;
    }

    /**
     * Метод getNextId генерирует следующий идентификатор поста.
     *
     * @return следующий идентификатор поста
     */
    private static Integer getNextId(){
        return globalId++;
    }
}
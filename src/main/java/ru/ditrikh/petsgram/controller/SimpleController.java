package ru.ditrikh.petsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс SimpleController представляет контроллер для представления стартовой страницы
 */
@RestController
public class SimpleController {

    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);

    /**
     * Обрабатывает GET-запрос к эндпоинту "/home" и
     *
     * @return возвращает текст "Питомцевграм" - название приложения
     */
    @GetMapping("/home")
    public String homePage() {
        log.debug("Получен запрос GET /home.");
        return "Питомцевграм";
    }
}
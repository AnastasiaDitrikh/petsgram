package ru.ditrikh.petsgram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс PetsgramApplication является основным классом приложения Petsgram.
 * Он аннотирован аннотацией @SpringBootApplication, которая объединяет аннотации @Configuration, @EnableAutoConfiguration и @ComponentScan.
 * В методе main() запускается приложение Spring Boot с помощью метода SpringApplication.run(),
 * где передается класс PetsgramApplication в качестве аргумента для указания источника конфигурации и запуска приложения.
 */
@SpringBootApplication
public class PetsgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetsgramApplication.class, args);
    }

}
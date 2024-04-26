package ru.usikov.taskmanagementsystem.web;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiMessageConstants {

    public static final String SUCCESS = "200";
    public static final String UNAUTHORIZED_CODE = "401";
    public static final String FORBIDDEN_CODE = "403";
    public static final String NOT_FOUND_CODE = "404";

    public static final String UNAUTHORIZED = "Без авторизации";
    public static final String FORBIDDEN = "Нет доступа";

    /**
     * Задачи
     * */
    public static final String NOT_FOUND_TASK = "Такой задачи не существует";

    /**
     * Пользователи
     * */
    public static final String NOT_FOUND_USER = "Такой пльзователь не найден";

}

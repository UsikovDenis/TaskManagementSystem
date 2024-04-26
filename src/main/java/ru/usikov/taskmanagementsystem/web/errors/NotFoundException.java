package ru.usikov.taskmanagementsystem.web.errors;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApplicationStatusException {

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

}

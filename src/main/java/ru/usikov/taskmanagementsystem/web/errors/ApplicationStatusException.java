package ru.usikov.taskmanagementsystem.web.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationStatusException extends RuntimeException {
    protected int code;

    public ApplicationStatusException(HttpStatus httpStatus, String message) {
        super(message);
        this.code = httpStatus.value();
    }
}

package ru.usikov.taskmanagementsystem;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;



@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtils {

    public static HttpHeaders getDefaultHeaders() {
        return getHeaders(MediaType.APPLICATION_JSON);
    }

    public static HttpHeaders getHeaders(final MediaType mediaType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        return headers;
    }
}

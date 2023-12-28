package ru.usikov.taskmanagementsystem;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
@Retention(RetentionPolicy.RUNTIME)
public @interface IntegrationTest {
}

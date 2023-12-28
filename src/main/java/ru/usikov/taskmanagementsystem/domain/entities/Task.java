package ru.usikov.taskmanagementsystem.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import ru.usikov.taskmanagementsystem.domain.entities.dictionary.TaskPriority;
import ru.usikov.taskmanagementsystem.domain.entities.dictionary.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "task")
@Getter
@Setter
public class Task {

    @Id
    @UuidGenerator
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_author_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_executor_id")
    private User executor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskPriority priority;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @PrePersist
    private void create() {
        createDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
    }

    @PreUpdate
    private void update() {
        updateDate = LocalDateTime.now();
    }

}

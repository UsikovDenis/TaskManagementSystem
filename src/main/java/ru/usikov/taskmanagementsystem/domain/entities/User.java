package ru.usikov.taskmanagementsystem.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "api_user")
@Getter
@Setter
public class User {

    @Id
    @UuidGenerator
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Task> authorTasks;

    @OneToMany(mappedBy = "executor")
    private List<Task> executorTasks;

}

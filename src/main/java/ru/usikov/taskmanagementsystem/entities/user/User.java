package ru.usikov.taskmanagementsystem.entities.user;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import ru.usikov.taskmanagementsystem.entities.task.Task;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @UuidGenerator
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(name = "role", length = 20)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles")
    @Enumerated(value = EnumType.STRING)
    private Set<UserRole> roles;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Task> authorTasks;

    @OneToMany(mappedBy = "executor", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Task> executorTasks;

}

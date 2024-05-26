package ru.usikov.taskmanagementsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.usikov.taskmanagementsystem.entities.user.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);

//    Boolean existsByUsername(String username);
//
//    Boolean existsByEmail(String email);

//    @Query(value = """
//            select u from User u
//            join Task t on t.author.id == u.id
//            where t.author.id = :taskId
//            """)
//    User findTaskAuthor(UUID taskId);

}

package ru.usikov.taskmanagementsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.usikov.taskmanagementsystem.entities.user.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    @Query(value = """
            SELECT u.id as id,
            u.name as name,
            u.username as username,
            u.password as password
            FROM users_authorTasks ut
            JOIN users u ON ut.author_id = u.id
            WHERE ut.author_id = :taskId
            """, nativeQuery = true)
    Optional<User> findTaskAuthor(UUID taskId);

    @Query(value = """
             SELECT exists(
                           SELECT 1
                           FROM users_authorTasks
                           WHERE user_id = :userId
                             AND task_id = :taskId)
            """, nativeQuery = true)
    boolean isTaskOwner(UUID userId, UUID taskId);



}

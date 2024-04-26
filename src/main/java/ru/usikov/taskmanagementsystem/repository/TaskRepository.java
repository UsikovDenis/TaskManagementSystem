package ru.usikov.taskmanagementsystem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.usikov.taskmanagementsystem.entities.task.Task;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>{

    @Query("from Task")
    Page<Task> findPage(Pageable pageable);

    @Query(value = """
            SELECT * FROM tasks t
            JOIN users_authorTasks ut ON ut.author_id = t.id
            WHERE ut.author_id = :userId
            """, nativeQuery = true)
    List<Task> findAllByUserId(UUID userId);

//    void addImage(UUID id, String fileName);

}

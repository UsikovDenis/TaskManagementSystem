package ru.usikov.taskmanagementsystem.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.usikov.taskmanagementsystem.domain.entities.Task;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>{

    @Query("from Task")
    Page<Task> findPage(Pageable pageable);

}

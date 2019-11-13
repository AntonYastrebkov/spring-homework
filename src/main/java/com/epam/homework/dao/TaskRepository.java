package com.epam.homework.dao;

import com.epam.homework.entity.Task;
import com.epam.homework.entity.TaskPriority;
import com.epam.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
//    Task createTask(String description, User user);

//    Task findById(Long id);

//     deleteById(Long taskId);

    List<Task> findAllByUserId(Long userId);

//    void setTaskPriority(Long id, TaskPriority taskPriority);
//
//    void markTaskAsComplete(Long taskId);
//
//    void markTaskAsNotComplete(Long taskId);
}
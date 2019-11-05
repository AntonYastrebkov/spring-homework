package com.epam.homework.dao;

import com.epam.homework.entity.Task;
import com.epam.homework.entity.TaskPriority;
import com.epam.homework.entity.User;
import java.util.List;

public interface TaskRepository {
    Task createTask(String description, User user);

    Task findTaskById(Long id);

    boolean deleteTaskById(Long taskId);

    List<Task> findAllTaskByUserId(Long userId);

    void setTaskPriority(Long id, TaskPriority taskPriority);

    void markTaskAsComplete(Long taskId);

    void markTaskAsNotComplete(Long taskId);
}
package com.epam.homework.service;

import com.epam.homework.entity.Task;
import com.epam.homework.entity.TaskPriority;
import com.epam.homework.entity.User;
import java.util.List;

public interface TaskService {
    Task createTask(String description, User user);

    boolean deleteTask(Long id);

    List<Task> findAllTasksByUserId(Long userId);

    void setTaskPriority(Long taskId, TaskPriority taskPriority);

    void markTaskComplete(Long taskId);

    void markTaskNotComplete(Long taskId);
}
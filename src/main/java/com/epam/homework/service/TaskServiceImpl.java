package com.epam.homework.service;

import com.epam.homework.dao.TaskRepository;
import com.epam.homework.entity.Task;
import com.epam.homework.entity.TaskPriority;
import com.epam.homework.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String description, User user) {
        return taskRepository.createTask(description, user);
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskRepository.deleteTaskById(id);
    }

    @Override
    public List<Task> findAllTasksByUserId(Long userId) {
        return taskRepository.findAllTaskByUserId(userId);
    }

    @Override
    public void setTaskPriority(Long taskId, TaskPriority taskPriority) {
        taskRepository.setTaskPriority(taskId, taskPriority);
    }

    @Override
    public void markTaskComplete(Long taskId) {
        taskRepository.markTaskAsComplete(taskId);
    }

    @Override
    public void markTaskNotComplete(Long taskId) {
        taskRepository.markTaskAsNotComplete(taskId);
    }
}

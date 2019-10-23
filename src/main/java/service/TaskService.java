package service;

import entities.Task;
import entities.TaskPriority;
import entities.User;
import java.util.List;

public interface TaskService {
    Task createTask(String description, User user);

    boolean deleteTask(Long id);

    List<Task> findAllTasksByUserId(Long userId);

    void setTaskPriority(Long taskId, TaskPriority taskPriority);

    void markTaskComplete(Long taskId);

    void markTaskNotComplete(Long taskId);
}

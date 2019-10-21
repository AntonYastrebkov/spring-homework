package dao;

import entities.Task;
import entities.User;

import java.util.List;

public interface TaskRepository {
    Task createTask(String description, User user);

    void deleteTaskById(Long taskId);

    List<Task> findAllTaskByUserId(Long userId);

    Task markTaskAsComplete(Long taskId);

    Task markTaskAsNotComplete(Long taskId);
}

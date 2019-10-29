package dao;

import entities.Task;
import entities.User;
import java.util.List;

public interface TaskRepository {
    Task createTask(String description, User user);

    boolean deleteTaskById(Long taskId);

    List<Task> findAllTaskByUserId(Long userId);

    void markTaskAsComplete(Long taskId);

    void markTaskAsNotComplete(Long taskId);
}

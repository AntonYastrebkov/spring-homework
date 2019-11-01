package dao;

import entities.Task;
import entities.TaskPriority;
import entities.User;
import java.util.List;

public interface TaskRepository {
    Task createTask(String description, User user);

    boolean deleteTaskById(Long taskId);

    List<Task> findAllTaskByUserId(Long userId);

    void setTaskPriority(Long id, TaskPriority taskPriority);

    void markTaskAsComplete(Long taskId);

    void markTaskAsNotComplete(Long taskId);
}

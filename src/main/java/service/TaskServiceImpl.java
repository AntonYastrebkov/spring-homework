package service;

import dao.TaskRepository;
import entities.Task;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
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
    public void markTaskComplete(Long taskId) {
        taskRepository.markTaskAsComplete(taskId);
    }

    @Override
    public void markTaskNotComplete(Long taskId) {
        taskRepository.markTaskAsNotComplete(taskId);
    }
}

package service;

import dao.TaskRepository;
import entities.Task;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;

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
}

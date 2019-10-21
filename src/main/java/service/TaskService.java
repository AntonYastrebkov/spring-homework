package service;

import entities.Task;
import entities.User;

public interface TaskService {
    Task createTask(String description, User user);

    boolean deleteTask(Long id);
}

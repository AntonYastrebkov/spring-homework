package controller;

import entities.Task;
import entities.User;
import exception.UserNotFoundException;
import exception.WrongPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.TaskService;
import service.UserService;

@Component
public class UserController {
    private final UserService userService;
    private final TaskService taskService;

    @Autowired
    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    public void singUp(String name, String email, String number, String password) {
        try {
            userService.registerNewUser(name, email, number, password);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("User successfully signed up!");
    }

    public User singIn(String email, String password) {
        User user = null;
        try {
            user = userService.signIn(email, password);
        } catch (UserNotFoundException | WrongPassword e) {
            System.out.println(e.getMessage());
        }
        if (user != null) {
            System.out.println("User registered:");
            System.out.println(user.toString());
        }
        return user;
    }

    public Task createTask(String description, User user) {
        Task task = taskService.createTask(description, user);
        System.out.println("Task created: \n" + task.getTaskDescription());
        return task;
    }

    public void deleteTask(Long taskId) {
        if (taskService.deleteTask(taskId)) {
            System.out.println("Task successfully deleted!");
        } else {
            System.out.println("No task with such ID found!");
        }
    }

    public void findAllUserTask(Long userId) {
        for (Task t : taskService.findAllTasksByUserId(userId)) {
            System.out.println(t.toString());
        }
    }

    public void markTaskComplete(Long taskId) {
        taskService.markTaskComplete(taskId);
    }

    public void markTaskNotComplete(Long taskId) {
        taskService.markTaskNotComplete(taskId);
    }
}

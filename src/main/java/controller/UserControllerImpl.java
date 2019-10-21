package controller;

import entities.Task;
import entities.User;
import exception.UserNotFoundException;
import exception.WrongPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.TaskService;
import service.UserService;

@Controller
public class UserControllerImpl {
  private final UserService userService;
  private final TaskService taskService;

  @Autowired
  public UserControllerImpl(UserService userService, TaskService taskService) {
    this.userService = userService;
    this.taskService = taskService;
  }

  // @Override
  public void singUp(String name, String email, String number, String password) {
    try {
      userService.registerNewUser(name, email, number, password);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }

  // @Override
  public void singIn(String email, String password) {
    try {
      User user = userService.signIn(email, password);
    } catch (UserNotFoundException | WrongPassword e) {
      System.out.println(e.getMessage());
    }

  }

  // @Override
  public Task createTask(String description, User user) {
    Task task = taskService.createTask(description, user);
    System.out.println("Task created: \n" + task.getTaskDescription());
    return task;
  }

  // @Override
  public void deleteTask(Long taskId) {
    if (taskService.deleteTask(taskId)) {
      System.out.println("Task successfully deleted!");
    }
    else {
      System.out.println("No task with such ID found!");
    }
  }

  // @Override
  public void findAllUserTask(Long userId) {

  }

  // @Override
  public void markTaskComplete(Task task) {
    task.setTaskComplete(true);
  }

  // @Override
  public void markTaskIncomplete(Task task) {
    task.setTaskComplete(false);
  }
}

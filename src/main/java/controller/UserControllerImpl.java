package controller;

import dao.TaskRepository;
import dao.UserRepository;
import entities.Task;
import entities.User;
import exception.UserNotFoundException;
import exception.WrongPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import service.UserService;

@Controller
public class UserControllerImpl {
  private final UserService userService;

  @Autowired
  public UserControllerImpl(UserService userService) {
    this.userService = userService;
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
  public Task createTask() {
    user
    return new Task();
  }

  // @Override
  public void deleteTask(Integer taskId) {

  }

  // @Override
  public void findAllUserTask(Integer userId) {

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

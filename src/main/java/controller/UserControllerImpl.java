package controller;

import dao.TaskRepository;
import dao.UserRepository;
import entities.Task;
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
  public void singUp(String email, String password) {


  }

  // @Override
  public void singIn() {

  }

  // @Override
  public Task createTask() {
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

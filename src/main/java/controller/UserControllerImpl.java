package controller;

import entities.Task;
import org.springframework.stereotype.Component;

@Component
public class UserControllerImpl implements UserController {

  @Override
  public UserController getUserController() {
    return new UserControllerImpl();
  }

  @Override
  public void singUp() {

  }

  @Override
  public void singIn() {

  }

  @Override
  public Task createTask() {
    return new Task();
  }

  @Override
  public void deleteTask(Integer taskId) {

  }

  @Override
  public void findAllUserTask(Integer userId) {

  }

  @Override
  public void markTaskComplete(Task task) {
    task.setTaskComplete(true);
  }

  @Override
  public void markTaskIncomplete(Task task) {
    task.setTaskComplete(false);
  }
}

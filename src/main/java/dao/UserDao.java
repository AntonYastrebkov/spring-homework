package dao;

import entities.Task;
import entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements UserRepository {
  private final List<User> userList;
  private List<Task> taskList;

  private long userIdCount;
  private long taskIdCount;

  public UserDao() {
    this.userList = new ArrayList<>();
    userIdCount = 1;
    taskIdCount = 1;
  }

  @Override
  public Task createTask(String description, User user) {
    Task task = new Task(taskIdCount++, description, false, user.getId());
    taskList.add(task);
    return task;
  }

  @Override
  public void deleteTaskById(Long taskId) {

  }

  @Override
  public List<Task> findAllTaskByUserId(Long userId) {
    return null;
  }

  @Override
  public Task markTaskAsComplete(Long taskId) {
    return null;
  }

  @Override
  public Task markTaskAsNotComplete(Long taskId) {
    return null;
  }

//  public Long getUserById() {
//    return user.getId();
//  }
//
//  public String getName() {
//    return user.getName();
//  }
//
//  public String getPhoneNumber() {
//    return user.getPhoneNumber();
//  }
//
//  public String getEmail() {
//    return user.getEmail();
//  }
//
//  public String getPassword() {
//    return user.getPassword();
//  }
}

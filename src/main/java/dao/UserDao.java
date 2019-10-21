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
    for (Task t : taskList) {
      if (t.getTaskId().equals(taskId)) {
        taskList.remove(t);
        break;
      }
    }
  }

  @Override
  public List<Task> findAllTaskByUserId(Long userId) {
    List<Task> list = new ArrayList<>();
    for (Task t : taskList) {
      if (t.getUserId().equals(userId)) {
        list.add(t);
      }
    }
    return list;
  }

  @Override
  public Task markTaskAsComplete(Long taskId) {
    for (Task t : taskList) {
      if (t.getTaskId().equals(taskId)) {
        t.setTaskComplete(true);
        return t;
      }
    }
    return null;
  }

  @Override
  public Task markTaskAsNotComplete(Long taskId) {
    for (Task t : taskList) {
      if (t.getTaskId().equals(taskId)) {
        t.setTaskComplete(false);
        return t;
      }
    }
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

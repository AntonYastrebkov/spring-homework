package controller;

import entities.Task;
import entities.TaskPriority;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

  private final TaskService taskService;

  @Autowired
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping("/{taskId}/change-priority")
  public void setTaskPriority(@PathVariable Long taskId, TaskPriority taskPriority) {
    taskService.setTaskPriority(taskId, taskPriority);
  }

  @PostMapping("/{taskId}/complete")
  public void markTaskComplete(@PathVariable Long taskId) {
    taskService.markTaskComplete(taskId);
  }

  @PostMapping("/{taskId}/not-complete")
  public void markTaskNotComplete(@PathVariable Long taskId) {
    taskService.markTaskNotComplete(taskId);
  }

  @PostMapping("/create")
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

}

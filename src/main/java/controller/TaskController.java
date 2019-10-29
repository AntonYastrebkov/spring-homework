package controller;

import entities.Task;
import entities.TaskPriority;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.TaskService;

@Component
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public void setTaskPriority(Long taskId, TaskPriority taskPriority) {
        taskService.setTaskPriority(taskId, taskPriority);
    }

    public void markTaskComplete(Long taskId) {
        taskService.markTaskComplete(taskId);
    }

    public void markTaskNotComplete(Long taskId) {
        taskService.markTaskNotComplete(taskId);
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

}

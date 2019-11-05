package com.epam.homework.controller;

import com.epam.homework.entity.Task;
import com.epam.homework.entity.TaskPriority;
import com.epam.homework.entity.User;
import com.epam.homework.exception.SubscriptionException;
import com.epam.homework.service.TaskService;
import com.epam.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
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

    @DeleteMapping("/{taskId}/delete")
    public void deleteTask(Long taskId) {
        if (taskService.deleteTask(taskId)) {
            System.out.println("Task successfully deleted!");
        } else {
            System.out.println("No task with such ID found!");
        }
    }

    @GetMapping("/{userId}/all")
    public void findAllUserTask(@PathVariable Long userId) {
        for (Task t : taskService.findAllTasksByUserId(userId)) {
            System.out.println(t.toString());
        }
    }

    @PostMapping("/{id}/upload")
    public void uploadFile(
            @PathVariable Long id,
            @RequestParam MultipartFile file,
            User user
    ) throws IOException {
        if (!userService.isSubscribed(user)) {
            throw new SubscriptionException("Subscribe to upload files!");
        }
        taskService.saveFile(id, file);
    }
}
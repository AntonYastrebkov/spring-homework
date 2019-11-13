package com.epam.homework.controller;

import com.epam.homework.entity.Task;
import com.epam.homework.entity.TaskPriority;
import com.epam.homework.entity.User;
import com.epam.homework.entity.UserDto;
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
        taskService.markTaskComplete(taskId, true);
    }

    @PostMapping("/{taskId}/not-complete")
    public void markTaskNotComplete(@PathVariable Long taskId) {
        taskService.markTaskComplete(taskId, false);
    }

    @PostMapping("/create")
    public Task createTask(String description, UserDto userDto) {
        Task task = taskService.createTask(description, userDto);
        System.out.println("Task created: \n" + task.getTaskDescription());
        return task;
    }

    @DeleteMapping("/{taskId}/delete")
    public void deleteTask(Long taskId) {
        taskService.deleteTask(taskId);
    }

    @GetMapping("/{userId}/all")
    public void findAllUserTask(@PathVariable Long userId) {
        for (Task t : taskService.findAllTasksByUserId(userId)) {
            System.out.println(t.toString());
        }
    }

    @PostMapping("/{id}/upload")
    public Task uploadFile(
            @PathVariable Long id,
            @RequestParam MultipartFile file,
            UserDto userDto
    ) throws IOException {
        if (!userService.isSubscribed(userDto)) {
            throw new SubscriptionException("Subscribe to upload files!");
        }
        return taskService.saveFile(id, file);
    }
}
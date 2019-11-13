package com.epam.homework.service;

import com.epam.homework.dao.TaskRepository;
import com.epam.homework.entity.Task;
import com.epam.homework.entity.TaskPriority;
import com.epam.homework.entity.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final String UPLOAD_PATH = "/C:/Users/Munchausen/IdeaProjects/com-epam-homework/uploads";

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String description, User user) {
        return taskRepository.createTask(description, user);
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskRepository.deleteTaskById(id);
    }

    @Override
    public List<Task> findAllTasksByUserId(Long userId) {
        return taskRepository.findAllTaskByUserId(userId);
    }

    @Override
    public void setTaskPriority(Long taskId, TaskPriority taskPriority) {
        taskRepository.setTaskPriority(taskId, taskPriority);
    }

    @Override
    public void markTaskComplete(Long taskId) {
        taskRepository.markTaskAsComplete(taskId);
    }

    @Override
    public void markTaskNotComplete(Long taskId) {
        taskRepository.markTaskAsNotComplete(taskId);
    }

    @Override
    public void saveFile(Long taskId, MultipartFile file) throws IOException {
        Task task = taskRepository.findTaskById(taskId);
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File destination = new File(UPLOAD_PATH);
            if (!destination.exists()) {
                destination.mkdirs();
            }

            String filename = UUID.randomUUID().toString() + "."
                    + file.getOriginalFilename();
            file.transferTo(new File(UPLOAD_PATH + "/" + filename));
            task.setFileName(filename);
        }
    }
}

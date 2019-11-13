package com.epam.homework.service;

import com.epam.homework.dao.TaskRepository;
import com.epam.homework.dao.UserRepository;
import com.epam.homework.entity.Task;
import com.epam.homework.entity.TaskPriority;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import com.epam.homework.entity.UserDto;
import com.epam.homework.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    @Value("${upload.path}")
    private String UPLOAD_PATH; // = "/C:/Users/Munchausen/IdeaProjects/com-epam-homework/uploads";

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Task createTask(String description, UserDto userDto) {

        Task task = new Task().builder()
                .taskDescription(description)
                .priority(TaskPriority.MEDIUM)
                .taskComplete(false)
                .fileName("")
                .user(userRepository.findByEmail(userDto.getEmail()))
                .build();
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAllTasksByUserId(Long userId) {
        return taskRepository.findAllByUserId(userId);
    }

    @Override
    public Task setTaskPriority(Long taskId, TaskPriority taskPriority) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("No task found!"));
        task.setPriority(taskPriority);
        return taskRepository.save(task);
    }

    @Override
    public Task markTaskComplete(Long taskId, Boolean completed) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("No task found!"));
        task.setTaskComplete(completed);
        return taskRepository.save(task);
    }

    @Override
    public Task saveFile(Long taskId, MultipartFile file) throws IOException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not fount!"));
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File destination = new File(UPLOAD_PATH);
            if (!destination.exists()) {
                destination.mkdirs();
            }

            String filename = UUID.randomUUID().toString() + "."
                    + file.getOriginalFilename();
            file.transferTo(new File(UPLOAD_PATH + "/" + filename));
            task.setFileName(filename);
            task = taskRepository.save(task);
        }
        return task;
    }
}

package com.epam.homework.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.homework.entity.Task;
import com.epam.homework.entity.TaskPriority;
import com.epam.homework.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDao implements TaskRepository {
    private List<Task> taskList;

    private long taskIdCount;

    public TaskDao() {
        this.taskList = new ArrayList<>();
        this.taskIdCount = 1;
    }

    @Override
    public Task createTask(String description, User user) {
        Task task = new Task(
                taskIdCount++, description, false, user.getId(), TaskPriority.HIGH);
        taskList.add(task);
        return task;
    }

    @Override
    public boolean deleteTaskById(Long taskId) {
        for (Task t : taskList) {
            if (t.getTaskId().equals(taskId)) {
                taskList.remove(t);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Task> findAllTaskByUserId(Long userId) {
        return taskList.stream()
                .filter(t -> t.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public void markTaskAsComplete(Long taskId) {
        taskList.stream()
                .filter(t -> t.getTaskId()
                        .equals(taskId))
                .forEach(t -> t.setTaskComplete(true));
    }

    @Override
    public void markTaskAsNotComplete(Long taskId) {
        taskList.stream()
                .filter(t -> t.getTaskId().equals(taskId))
                .forEach(t -> t.setTaskComplete(false));
    }

    @Override
    public void setTaskPriority(Long id, TaskPriority taskPriority) {
        taskList.stream().filter(t -> t.getTaskId()
                .equals(id))
                .forEach(t -> t.setPriority(taskPriority));
    }
}
package controller;

import entities.Task;

public class UserController {

    public void singUp() {

    }

    public void singIn() {

    }

    public void createTask() {

    }

    public void deleteTask(Integer taskId) {

    }

    public void findAllUserTask(Integer userId) {

    }

    public void markTaskComplete(Task task) {
        task.setTaskComplete(true);
    }

    public void markTaskIncomplete(Task task) {
        task.setTaskComplete(false);
    }
}

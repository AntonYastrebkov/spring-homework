package controller;

import entities.Task;

public class UserCotrollerImpl implements UserController{

    @Override
    public void singUp() {

    }

    @Override
    public void singIn() {

    }

    @Override
    public Task createTask() {
        return new Task();
    }

    @Override
    public void deleteTask(Integer taskId) {

    }

    @Override
    public void findAllUserTask(Integer userId) {

    }

    @Override
    public void markTaskComplete(Task task) {
        task.setTaskComplete(true);
    }

    @Override
    public void markTaskIncomplete(Task task) {
        task.setTaskComplete(false);
    }
}

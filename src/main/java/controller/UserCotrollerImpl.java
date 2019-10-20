package controller;

import entities.Task;
import entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class UserCotrollerImpl implements UserController{

    @Bean
    public UserController getUserController() {
        return new UserCotrollerImpl();
    }

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

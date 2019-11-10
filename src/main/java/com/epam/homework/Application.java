package com.epam.homework;

import com.epam.homework.config.ApplicationConfig;
import com.epam.homework.controller.UserController;
import com.epam.homework.controller.TaskController;
import com.epam.homework.entity.Task;
import com.epam.homework.entity.TaskPriority;
import com.epam.homework.entity.User;
import com.epam.homework.entity.UserRole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext();
//    ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("configuration.xml");
//    SecurityService service = xmlContext.getBean(SecurityService.class);
    context.register(ApplicationConfig.class);
    context.refresh();
    UserController userController = context.getBean(UserController.class);
    TaskController taskController = context.getBean(TaskController.class);
    User user1 = new User(1l, "name", "email@dot.com", "+789456123", "password", "secret", UserRole.ORDINARY_USER);
    userController.singUp(user1);
    User user2 = new User(2l, "name2", "email2@dot.com", "+7894561234", "password", "adadsd", UserRole.ADMIN_USER);
    userController.singUp(user2);
    User user = userController.singIn("email@dot.com", "password");
    Task task = taskController.createTask("kuhvckwgw", user);
    taskController.createTask("kuhv", user);
    taskController.findAllUserTask(user.getId());

    taskController.setTaskPriority(task.getTaskId(), TaskPriority.LOW);
    userController.subscribe(user.getEmail());
    userController.subscribe(user.getEmail());
    userController.subscribe(user.getEmail());
    taskController.markTaskComplete(task.getTaskId());

    taskController.findAllUserTask(user.getId());
    taskController.markTaskComplete(3L);
    userController.adminCheck("email@dot.com");
    userController.adminCheck("email2@dot.com");
    }
}

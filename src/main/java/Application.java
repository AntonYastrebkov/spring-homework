import controller.UserController;
import entities.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  public static void main(String[] args) {
    ApplicationContext taskContext =
        new AnnotationConfigApplicationContext("entities");
    ApplicationContext controllerContext =
        new AnnotationConfigApplicationContext("controller");

    Task task = taskContext.getBean(Task.class);
    UserController userController = controllerContext.getBean(UserController.class);
    System.out.println(userController.createTask());
    System.out.println(task.getTaskComplete());
  }
}

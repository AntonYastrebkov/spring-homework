import controller.UserController;
import dao.TaskDao;
import entities.Task;
import entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  public static void main(String[] args) {
    ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext("controller");

    UserController controller = applicationContext.getBean(UserController.class);
    
  }
}

import config.ApplicationConfig;
import controller.UserController;
import entities.Task;
import entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext();

    context.register(ApplicationConfig.class);
    context.refresh();

    UserController userController = context.getBean(UserController.class);

    User user = new User(0l, "firstUser", "user@user.com", "+7911", "password");
  }
}

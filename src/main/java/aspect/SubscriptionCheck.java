package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SubscriptionCheck {
    private static final String IS_SUBSCRIBED = "5ebe2294ecd0e0f08eab7690d2a6ee69";

    @Pointcut("execution(public * service.TaskServiceImpl.createTask(..))")
    public void onTaskCreate() { };

    @Before("onTaskCreate()")
    public void beforeTaskCreate(JoinPoint jp) {
        System.out.println("Aspect is here!");
    }
}

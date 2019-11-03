package exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(EmailExistsException.class)
    public String emailExistsHandler(EmailExistsException e) {
        return e.getMessage();
    }

    @ExceptionHandler(TaskOverflowException.class)
    public String taskOverflowHandler(TaskOverflowException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundHandler(UserNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UserRoleException.class)
    public String userRoleHandler(UserRoleException e) {
        return e.getMessage();
    }

    @ExceptionHandler(WrongPassword.class)
    public String wrongPasswordHandler(WrongPassword e) {
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String unresolvedExceptions(Exception e) {
        return e.getMessage();
    }
}

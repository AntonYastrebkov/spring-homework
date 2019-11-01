package exception;

public class TaskOverflowException extends RuntimeException {
    public TaskOverflowException(String message) {
        super(message);
    }
}

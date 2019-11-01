package entities;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Long taskId;
    private String taskDescription;
    private Boolean taskComplete;
    private Long userId;
    private TaskPriority priority = TaskPriority.MEDIUM;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(taskId, task.taskId) &&
                Objects.equals(taskDescription, task.taskDescription) &&
                Objects.equals(taskComplete, task.taskComplete) &&
                Objects.equals(userId, task.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskDescription, taskComplete, userId);
    }

    @Override
    public String toString() {
        return "Task: {id=" + taskId.toString() +
                "description=\"" + taskDescription +
                "\" completed=" + taskComplete +
                " userID=" + userId.toString() +
                " priority=" + priority + "}";
    }
}

package dao;

import entities.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskDao {

    private Task task = new Task();

    @Bean
    public Task getTask() {
        return task;
    }

    public Integer getTaskId() {
        return task.getTaskId();
    }

    public String getTaskDescription() {
        return task.getTaskDescription();
    }

    public Boolean getTaskComplete() {
        return task.getTaskComplete();
    }

    public Integer getTaskUserId() {
        return task.getUserId();
    }

}

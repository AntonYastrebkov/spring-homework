package dao;

import entities.Task;

public class TaskDao {

    private Task task = new Task();

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

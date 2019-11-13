package com.epam.homework.entity;

import java.util.Objects;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    private String taskDescription;
    private Boolean taskComplete;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
    @Enumerated(EnumType.STRING)
    private TaskPriority priority = TaskPriority.MEDIUM;
    private String fileName;

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
                Objects.equals(user.getId(), task.getUser().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskDescription, taskComplete, user.getId());
    }

    @Override
    public String toString() {
        return "Task: {id=" + taskId.toString() +
                "description=\"" + taskDescription +
                "\" completed=" + taskComplete +
                " userID=" + user.getId().toString() +
                " priority=" + priority + "}";
    }
}
package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Integer taskId;
    private String taskDescription;
    private Boolean taskComplete;
    private Integer userId;
}

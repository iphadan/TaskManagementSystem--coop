package cbo.taskManagementSystem.dtos;

import cbo.taskManagementSystem.enums.TaskCategory;
import cbo.taskManagementSystem.enums.TaskStatus;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskDTO {

    private long id;
    private String engineerName;
    private TaskCategory taskCategory;
    private TaskStatus status;

    private String assignment;
    private LocalDateTime startDateTime;
    private LocalDateTime dueDateTime;
    private long timeSpent;
    private LocalDateTime taskCreatedDateTime;



}

package cbo.taskManagementSystem.models;

import cbo.taskManagementSystem.enums.TaskCategory;
import cbo.taskManagementSystem.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
public class Task {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String engineerName;
    private TaskCategory taskCategory;
    private TaskStatus status;
    @Column(columnDefinition = "text")
    private String assignment;
    private LocalDateTime startDateTime;
    private LocalDateTime dueDateTime;
    private long timeSpent;
    private LocalDateTime taskCreatedDateTime;


}

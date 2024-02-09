package cbo.taskManagementSystem.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskStatus {

    InProgress("In Progress"),
    Done("Done"),
    NotStarted("Not Started"),
    Skipped("Skipped");

    private String type;

    public static TaskStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (TaskStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }


}

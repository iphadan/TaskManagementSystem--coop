package cbo.taskManagementSystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskCategory {

    Development("Development"),
    Temenos("Temenos"),
    Customization("Customization"),
    InternalITSM("Internal ITSM"),
    Others("Others"),
    TemenosTCSP("Temenos TCSP");

    private String type;

    public static TaskCategory decode(String type) {
        if (type != null && type.length() > 0) {
            for (TaskCategory obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }



}

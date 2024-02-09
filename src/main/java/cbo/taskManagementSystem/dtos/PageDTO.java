package cbo.taskManagementSystem.dtos;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
public class PageDTO implements Serializable {
@Serial
    private static final long serialVersionUID = 6328361336342412365L;

    private int currentPage;
    private long totalRows;
    private int pageSize;
    private String sortColumn;
    private String sortDirection = "desc";

}


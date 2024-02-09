package cbo.taskManagementSystem.controllers;

import cbo.taskManagementSystem.dtos.ResultWrapper;
import cbo.taskManagementSystem.dtos.TaskDTO;
import cbo.taskManagementSystem.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class TaskController {
    @Autowired
    private TaskServices taskServices;

    @PostMapping(value = "task/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<TaskDTO>> createTask(@RequestBody TaskDTO taskDTO){
        ResultWrapper<TaskDTO> resultWrapper=taskServices.createTask(taskDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.CREATED);
    }
    @PostMapping(value = "task/getAll",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ResultWrapper<List<TaskDTO>>> getAllTasks(){
        ResultWrapper<List<TaskDTO>> resultWrapper=taskServices.getAllTasks();

        return new ResponseEntity<>(resultWrapper, HttpStatus.CREATED);
    }
    @PostMapping(value = "task/get",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ResultWrapper<TaskDTO>> getTask(@RequestBody TaskDTO taskDTO){
        ResultWrapper<TaskDTO> resultWrapper=taskServices.getTask(taskDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
    @PostMapping(value = "task/delete",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ResultWrapper<String>> deleteTask(@RequestBody TaskDTO taskDTO){
        ResultWrapper<String> resultWrapper=taskServices.deleteTask(taskDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
}

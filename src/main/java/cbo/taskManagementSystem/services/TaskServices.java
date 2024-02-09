package cbo.taskManagementSystem.services;

import cbo.taskManagementSystem.dtos.ResultWrapper;
import cbo.taskManagementSystem.dtos.TaskDTO;
import cbo.taskManagementSystem.mappers.TaskMapper;
import cbo.taskManagementSystem.models.Task;
import cbo.taskManagementSystem.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TaskServices {
@Autowired
private TaskRepository taskRepository;
public ResultWrapper<TaskDTO> createTask(TaskDTO taskDTO){

    //here check what if the mandatory fields contain info or not
    System.out.println(taskDTO.getEngineerName()+taskDTO.getTaskCategory()+taskDTO.getAssignment());

    ResultWrapper<TaskDTO> resultWrapper=new ResultWrapper<>();
    try{
        taskDTO.setTaskCreatedDateTime(LocalDateTime.now());
        Task task=taskRepository.save(TaskMapper.INSTANCE.toEntity(taskDTO));
        resultWrapper.setMessage("success");
        System.out.println(task.getEngineerName()+task.getTaskCategory()+task.getAssignment());

        resultWrapper.setResult(TaskMapper.INSTANCE.toDTO(task));
        resultWrapper.setStatus(true);
        return resultWrapper;

    }catch (Exception e){
        resultWrapper.setStatus(false);
        resultWrapper.setResult(null);
        resultWrapper.setMessage("There was some error, try again later!");
        return resultWrapper;
    }


}
    public ResultWrapper<TaskDTO> getTask(TaskDTO taskDTO){

        //here check what if the mandatory fields contain info or not


        ResultWrapper<TaskDTO> resultWrapper=new ResultWrapper<>();
        try{
            Task task=taskRepository.findById(taskDTO.getId()).orElse(null);
            if(task == null){
                resultWrapper.setStatus(false);
                resultWrapper.setResult(null);
                resultWrapper.setMessage("There is no Task with the related information!");
                return resultWrapper;
            }

            resultWrapper.setMessage("success");
            resultWrapper.setResult(TaskMapper.INSTANCE.toDTO(task));
            resultWrapper.setStatus(true);
            return resultWrapper;

        }catch (Exception e){
            resultWrapper.setStatus(false);
            resultWrapper.setResult(null);
            resultWrapper.setMessage("There was some error, try again later!");
            return resultWrapper;
        }


    }

    public ResultWrapper<List<TaskDTO>> getAllTasks(){

        //here check what if the mandatory fields contain info or not


        ResultWrapper<List<TaskDTO>> resultWrapper=new ResultWrapper<>();
        try{
            List<Task> tasks=taskRepository.findAll();
            resultWrapper.setMessage("success");
            resultWrapper.setResult(TaskMapper.INSTANCE.TaskToTaskDTOs(tasks));
            resultWrapper.setStatus(true);
            return resultWrapper;

        }catch (Exception e){
            resultWrapper.setStatus(false);
            resultWrapper.setResult(null);
            resultWrapper.setMessage("There was some error, try again later!");
            return resultWrapper;
        }


    }


    public ResultWrapper<String> deleteTask(TaskDTO taskDTO){

        //here check what if the mandatory fields contain info or not


        ResultWrapper<String> resultWrapper=new ResultWrapper<>();
        try{
            Task task=taskRepository.findById(taskDTO.getId()).orElse(null);


            if(task == null){
                resultWrapper.setStatus(false);
                resultWrapper.setResult(null);
                resultWrapper.setMessage("There is no Task with the related information to delete!");
                return resultWrapper;
            }
            taskRepository.deleteById(taskDTO.getId());
            resultWrapper.setMessage("success");
            resultWrapper.setResult(null);
            resultWrapper.setStatus(true);
            return resultWrapper;

        }catch (Exception e){
            resultWrapper.setStatus(false);
            resultWrapper.setResult(null);
            resultWrapper.setMessage("There was some error, try again later!");
            return resultWrapper;
        }


    }


}

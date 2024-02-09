package cbo.taskManagementSystem.mappers;

import cbo.taskManagementSystem.dtos.TaskDTO;
import cbo.taskManagementSystem.models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO toDTO(Task task);

    void copyToDTO(Task task, @MappingTarget TaskDTO taskDTO);

    Task toEntity(TaskDTO taskDTO);

    default List<TaskDTO> TaskToTaskDTOs(List<Task> tasks) {
        if (tasks == null) {
            return null;
        }

        List<TaskDTO> list = new ArrayList<TaskDTO>(tasks.size());
        for (Task task : tasks) {
            list.add(toDTO(task));
        }

        return list;
    }


}

package org.suryansh.service;

import org.suryansh.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTask();

    TaskDto getTaskById(int id);

    String addNewTask(TaskDto taskDto);

    String updateTask(int id, TaskDto taskDto);

    String deleteTaskById(int id);
}

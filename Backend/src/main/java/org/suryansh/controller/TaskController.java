package org.suryansh.controller;

import org.springframework.web.bind.annotation.*;
import org.suryansh.dto.TaskDto;
import org.suryansh.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("api/task/")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("all")
    private List<TaskDto> getAllTask(){
        return taskService.getAllTask();
    }
    @GetMapping("by-id/{id}")
    private TaskDto getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }
    @PostMapping("add-new")
    private String addNewTask(@RequestBody TaskDto taskDto) {
        return taskService.addNewTask(taskDto);
    }
    @PutMapping("update-by-id/{id}")
    private String updateTaskById(@PathVariable int id, @RequestBody TaskDto taskDto) {
        return taskService.updateTask(id,taskDto);
    }
    @DeleteMapping("delete-by-id/{id}")
    private String deleteTaskById(@PathVariable int id) {
        return taskService.deleteTaskById(id);
    }
}

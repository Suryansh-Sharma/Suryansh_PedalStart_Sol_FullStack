package org.suryansh.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.suryansh.dto.TaskDto;
import org.suryansh.entity.Task;
import org.suryansh.repository.TaskRepo;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public List<TaskDto> getAllTask() {
        return taskRepo.findAll().stream()
                .map(t -> new TaskDto(
                        t.getTaskId(),
                        t.getTaskName(),
                        "",
                        t.getGeneratedOn(),
                        t.getDueDate()
                ))
                .toList();
    }

    @Override
    public TaskDto getTaskById(int id) {
        Task t = taskRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Task not found"));
        return new TaskDto(
                t.getTaskId(),
                t.getTaskName(),
                t.getTaskDescription(),
                t.getGeneratedOn(),
                t.getDueDate()
        );
    }

    @Override
    @Transactional
    public String addNewTask(TaskDto dto) {
        Task task = Task.builder()
                .taskName(dto.title())
                .taskDescription(dto.description())
                .generatedOn(LocalDateTime.now())
                .dueDate(dto.dueDate())
                .build();
        try {
            taskRepo.save(task);
            return "Task added successfully";
        }catch (Exception e) {
            return "Task could not be added";
        }
    }

    @Override
    @Transactional
    public String updateTask(int id, TaskDto taskDto) {
        Task t = taskRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Task not found"));
        t.setTaskName(taskDto.title());
        t.setTaskDescription(taskDto.description());
        t.setDueDate(taskDto.dueDate());
        try {
            taskRepo.save(t);
            return "Task updated successfully";
        }catch (Exception e) {
            return "Task could not be updated";
        }
    }

    @Override
    @Transactional
    public String deleteTaskById(int id) {
        Task t = taskRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Task not found"));
        try {
            taskRepo.delete(t);
            return "Task deleted successfully";
        }catch (Exception e) {
            return "Task could not be deleted";
        }
    }
}

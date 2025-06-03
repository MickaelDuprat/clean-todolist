package fr.mickaelduprat.cleantodolist.controllers;

import fr.mickaelduprat.cleantodolist.models.Task;
import fr.mickaelduprat.cleantodolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.findAll();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Task>> getPendingTasks() {
        List<Task> pendingTasks = taskService.findPendingTasks();
        return ResponseEntity.ok(pendingTasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Task> completeTask(@PathVariable Long id) {
        return taskService.findById(id)
                .map(task -> {
                    task.setCompleted(true);
                    Task updatedTask = taskService.save(task);
                    return ResponseEntity.ok(updatedTask);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

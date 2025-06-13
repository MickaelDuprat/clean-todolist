package fr.mickaelduprat.cleantodolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import fr.mickaelduprat.cleantodolist.model.Task;
import fr.mickaelduprat.cleantodolist.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/not-completed")
    public List<Task> getAllTasksToPerform() {
        return taskService.getAllTasksToPerform();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        if (!id.equals(task.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Task updatedTask = taskService.saveTask(task);
        return ResponseEntity.ok(updatedTask);
    }

    @PatchMapping("/{id}/completed")
    public ResponseEntity<Task> updateTaskCompleted(@PathVariable Long id, @RequestBody boolean completed) {

        return taskService.getTaskById(id)
                .map(task -> {
                    task.setCompleted(completed);
                    Task updatedTask = taskService.saveTask(task);
                    return ResponseEntity.ok(updatedTask);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}

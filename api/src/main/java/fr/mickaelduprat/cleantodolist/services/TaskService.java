package fr.mickaelduprat.cleantodolist.services;

import fr.mickaelduprat.cleantodolist.models.Task;
import fr.mickaelduprat.cleantodolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findPendingTasks() {
        return taskRepository.findAll().stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }
}

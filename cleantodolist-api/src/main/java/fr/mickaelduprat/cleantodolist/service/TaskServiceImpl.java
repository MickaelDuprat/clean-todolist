package fr.mickaelduprat.cleantodolist.service;

import java.util.List;
import java.util.Optional;

import fr.mickaelduprat.cleantodolist.model.Task;

public interface TaskServiceImpl {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Task saveTask(Task task);
    void deleteTask(Long id);
}
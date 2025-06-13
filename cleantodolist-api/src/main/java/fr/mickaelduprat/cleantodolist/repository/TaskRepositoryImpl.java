package fr.mickaelduprat.cleantodolist.repository;

import fr.mickaelduprat.cleantodolist.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryImpl {
    List<Task> findAll();

    List<Task> findAllTasksToPerform();

    Optional<Task> findById(Long id);

    Task save(Task task);

    void deleteById(Long id);
}

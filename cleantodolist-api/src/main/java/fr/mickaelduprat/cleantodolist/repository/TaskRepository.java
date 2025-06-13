package fr.mickaelduprat.cleantodolist.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import fr.mickaelduprat.cleantodolist.model.Task;

import static fr.mickaelduprat.cleantodolist.repository.InMemoryTaskRepository.getTask;

@Repository
public class TaskRepository implements TaskRepositoryImpl {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    @Override
    public List<Task> findAllTasksToPerform() {
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> findById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    @Override
    public Task save(Task task) {
        return getTask(task, counter, tasks);
    }

    @Override
    public void deleteById(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}

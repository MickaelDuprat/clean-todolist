package fr.mickaelduprat.cleantodolist.repositories;

import fr.mickaelduprat.cleantodolist.models.Task;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public Optional<Task> findById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(counter.incrementAndGet());
            tasks.add(task);
        } else {
            tasks.removeIf(t -> t.getId().equals(task.getId()));
            tasks.add(task);
        }
        return task;
    }
}

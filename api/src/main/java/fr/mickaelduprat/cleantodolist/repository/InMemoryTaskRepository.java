package fr.mickaelduprat.cleantodolist.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import fr.mickaelduprat.cleantodolist.model.Task;

@Repository
public class InMemoryTaskRepository implements TaskRepositoryImpl {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    @Override
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

    @Override
    public void deleteById(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}

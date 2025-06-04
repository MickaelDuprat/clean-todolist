package fr.mickaelduprat.cleantodolist;

import fr.mickaelduprat.cleantodolist.repository.TaskRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import fr.mickaelduprat.cleantodolist.model.Task;
import fr.mickaelduprat.cleantodolist.repository.TaskRepository;
import fr.mickaelduprat.cleantodolist.repository.InMemoryTaskRepository;

public class InMemoryTaskRepositoryTest {

    private TaskRepositoryImpl taskRepositoryImpl;

    @BeforeEach
    public void setUp() {
        taskRepositoryImpl = new InMemoryTaskRepository();
    }

    @Test
    public void testSaveAndFindById() {
        Task task = new Task(null, "Test Task", "Description", false);
        Task savedTask = taskRepositoryImpl.save(task);

        Optional<Task> foundTask = taskRepositoryImpl.findById(savedTask.getId());
        assertTrue(foundTask.isPresent());
        assertEquals(savedTask.getId(), foundTask.get().getId());
        assertEquals("Test Task", foundTask.get().getLabel());
    }

    @Test
    public void testFindAll() {
        Task task1 = new Task(null, "Task 1", "Description 1", false);
        Task task2 = new Task(null, "Task 2", "Description 2", true);

        taskRepositoryImpl.save(task1);
        taskRepositoryImpl.save(task2);

        List<Task> tasks = taskRepositoryImpl.findAll();
        assertEquals(2, tasks.size());
    }

    @Test
    public void testDeleteById() {
        Task task = new Task(null, "Test Task", "Description", false);
        Task savedTask = taskRepositoryImpl.save(task);

        taskRepositoryImpl.deleteById(savedTask.getId());
        Optional<Task> deletedTask = taskRepositoryImpl.findById(savedTask.getId());
        assertFalse(deletedTask.isPresent());
    }
}

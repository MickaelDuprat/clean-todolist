package fr.mickaelduprat.cleantodolist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import fr.mickaelduprat.cleantodolist.model.Task;
import fr.mickaelduprat.cleantodolist.repository.TaskRepository;
import fr.mickaelduprat.cleantodolist.repository.InMemoryTaskRepository;

class InMemoryTaskRepositoryTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = new InMemoryTaskRepository();
    }

    @Test
    void testSaveAndFindById() {
        Task task = new Task(null, "Test Task", "Description", false);
        Task savedTask = taskRepository.save(task);

        Optional<Task> foundTask = taskRepository.findById(savedTask.getId());
        assertTrue(foundTask.isPresent());
        assertEquals(savedTask.getId(), foundTask.get().getId());
        assertEquals("Test Task", foundTask.get().getLabel());
    }

    @Test
    void testFindAll() {
        Task task1 = new Task(null, "Task 1", "Description 1", false);
        Task task2 = new Task(null, "Task 2", "Description 2", true);

        taskRepository.save(task1);
        taskRepository.save(task2);

        List<Task> tasks = taskRepository.findAll();
        assertEquals(2, tasks.size());
    }

    @Test
    void testDeleteById() {
        Task task = new Task(null, "Test Task", "Description", false);
        Task savedTask = taskRepository.save(task);

        taskRepository.deleteById(savedTask.getId());
        Optional<Task> deletedTask = taskRepository.findById(savedTask.getId());
        assertFalse(deletedTask.isPresent());
    }
}

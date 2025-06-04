package fr.mickaelduprat.cleantodolist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import fr.mickaelduprat.cleantodolist.model.Task;
import fr.mickaelduprat.cleantodolist.repository.TaskRepository;
import fr.mickaelduprat.cleantodolist.service.TaskServiceImpl;

public class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTasks() {
        Task task1 = new Task(1L, "Task 1", "Description 1", false);
        Task task2 = new Task(2L, "Task 2", "Description 2", true);

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<Task> tasks = taskService.getAllTasks();
        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    public void testGetTaskById() {
        Task task = new Task(1L, "Test Task", "Description", false);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Optional<Task> foundTask = taskService.getTaskById(1L);
        assertTrue(foundTask.isPresent());
        assertEquals(1L, foundTask.get().getId());
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveTask() {
        Task task = new Task(null, "Test Task", "Description", false);
        Task savedTask = new Task(1L, "Test Task", "Description", false);

        when(taskRepository.save(task)).thenReturn(savedTask);

        Task result = taskService.saveTask(task);
        assertEquals(1L, result.getId());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testDeleteTask() {
        doNothing().when(taskRepository).deleteById(1L);

        taskService.deleteTask(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }
}

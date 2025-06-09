package fr.mickaelduprat.cleantodolist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import fr.mickaelduprat.cleantodolist.controller.TaskController;
import fr.mickaelduprat.cleantodolist.model.Task;
import fr.mickaelduprat.cleantodolist.service.TaskService;

class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTasks() {
        Task task1 = new Task(1L, "Task 1", "Description 1", false);
        Task task2 = new Task(2L, "Task 2", "Description 2", true);

        when(taskService.getAllTasks()).thenReturn(Arrays.asList(task1, task2));

        List<Task> tasks = taskController.getAllTasks();
        assertEquals(2, tasks.size());
        verify(taskService, times(1)).getAllTasks();
    }

    @Test
    void testGetTaskById() {
        Task task = new Task(1L, "Test Task", "Description", false);

        when(taskService.getTaskById(1L)).thenReturn(Optional.of(task));

        ResponseEntity<Task> response = taskController.getTaskById(1L);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(1L, response.getBody().getId());
        verify(taskService, times(1)).getTaskById(1L);
    }

    @Test
    void testCreateTask() {
        Task task = new Task(null, "Test Task", "Description", false);
        Task savedTask = new Task(1L, "Test Task", "Description", false);

        when(taskService.saveTask(task)).thenReturn(savedTask);

        Task result = taskController.createTask(task);
        assertEquals(1L, result.getId());
        verify(taskService, times(1)).saveTask(task);
    }

    @Test
    void testUpdateTask() {
        Task task = new Task(1L, "Test Task", "Description", false);

        when(taskService.saveTask(task)).thenReturn(task);

        ResponseEntity<Task> response = taskController.updateTask(1L, task);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(1L, response.getBody().getId());
        verify(taskService, times(1)).saveTask(task);
    }

    @Test
    void testDeleteTask() {
        doNothing().when(taskService).deleteTask(1L);

        ResponseEntity<Void> response = taskController.deleteTask(1L);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(taskService, times(1)).deleteTask(1L);
    }
}

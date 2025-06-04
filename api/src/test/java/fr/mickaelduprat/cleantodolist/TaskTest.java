package fr.mickaelduprat.cleantodolist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import fr.mickaelduprat.cleantodolist.model.Task;

public class TaskTest {

    @Test
    public void testGettersAndSetters() {
        Task task = new Task();

        task.setId(1L);
        task.setLabel("Test du get du label d'une tâche");
        task.setDescription("Description de test");
        task.setCompleted(true);

        assertEquals(1L, task.getId());
        assertEquals("Test du get du label d'une tâche", task.getLabel());
        assertEquals("Description de test", task.getDescription());
        assertTrue(task.isCompleted());
    }
}

package fr.mickaelduprat.cleantodolist.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private String label;
    private String description;
    private boolean completed;
}

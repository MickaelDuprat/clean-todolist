package fr.mickaelduprat.cleantodolist.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private Long id;
    private String label;
    private String description;
    private boolean completed;
}

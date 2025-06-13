import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { Task } from '../../../core/models/task.model';
import {TaskOperationsService} from "../../../core/services/tasks/task-operations.service";

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  standalone: true,
  imports: [
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
    MatButtonModule,
    FormsModule
  ],
  styleUrls: ['./add-task.component.scss']
})
export class AddTaskComponent {
  newTask: Omit<Task, 'id'> = {
    label: '',
    description: '',
    completed: false
  };

  constructor(private readonly taskOperationsService: TaskOperationsService) {}

  addTask(): void {
    this.taskOperationsService.addNewTask(this.newTask);
    this.taskOperationsService.navToHome();
  }
}

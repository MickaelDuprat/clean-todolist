import {Component, OnInit} from '@angular/core';
import { NgIf } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { MatIcon } from "@angular/material/icon";
import { MatProgressSpinner } from "@angular/material/progress-spinner";

import { Task } from '../../../core/models/task.model';
import { TaskOperationsService } from "../../../core/services/tasks/task-operations.service";

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  standalone: true,
  imports: [
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
    MatButtonModule,
    FormsModule,
    MatIcon,
    MatProgressSpinner,
    NgIf
  ],
  styleUrls: ['./update-task.component.scss']
})

export class UpdateTaskComponent implements OnInit {
  updateTask: Task = { id: 0, label: '', description: '', completed: false };
  loading = true;
  error: string | null = null;

  constructor(
      private readonly taskOperationsService: TaskOperationsService,
      private readonly route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.loadTask();
  }

  loadTask(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (isNaN(id)) {
      this.error = 'ID de tâche invalide';
      this.loading = false;
      return;
    }

    this.taskOperationsService.getTaskWithId(id).subscribe({
      next: (task) => {
        this.updateTask = task;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erreur lors du chargement de la tâche';
        this.loading = false;
      }
    });
  }

  updateTaskSubmit(): void {
    this.taskOperationsService.updateTheTask(this.updateTask.id, this.updateTask);
  }

  deleteTask(taskId: number): void {
    this.taskOperationsService.deleteTaskAndBack(taskId);
  }
}

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatRippleModule } from '@angular/material/core';
import { Router, RouterModule } from '@angular/router';
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";
import { MatIconModule } from "@angular/material/icon";
import {MatCheckbox} from "@angular/material/checkbox";
import { Task } from '../../../core/models/task.model';
import { TaskOperationsService } from "../../../core/services/tasks/task-operations.service";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule,
    MatButtonModule,
    RouterModule,
    MatRippleModule,
    MatProgressSpinnerModule,
    MatIconModule,
    MatCheckbox
  ],
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {
  tasks: Task[] = [];

  constructor(private readonly taskOperationsService: TaskOperationsService, private readonly router: Router ) {}

  ngOnInit(): void {
    this.loadTasks();
  }

  loadTasks(): void {
    this.taskOperationsService.getAllNotCompletedTasks().subscribe(tasks => {
      this.tasks = tasks;
    });
  }

  toggleTaskStatus(task: Task): void {
    this.taskOperationsService.toggleTaskStatus(this.tasks, task);
  }

  deleteTask(taskId: number): void {
    this.taskOperationsService.deleteTaskAndUpdate(this.tasks, taskId);
  }

  updateTask(taskId: number): void {
    this.taskOperationsService.navToUpdateTask(taskId);
  }
}

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { TaskService } from './task.service';
import { Task } from '../../models/task.model';


@Injectable({
  providedIn: 'root'
})
export class TaskOperationsService extends TaskService {
  tasks: Task[] = [];

  constructor(private readonly router: Router, http: HttpClient) {
    super(http);
  }

  getAllTaskWithAnyStatus(): void {
    this.getAllTasks().subscribe({
      next: (tasks) => {
        this.tasks = tasks;
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  getAllTaskNotCompleted(): Observable<Task[]> {
    return this.getAllNotCompletedTasks();
  }

  getTaskWithId(id: number): Observable<Task> {
    return this.getTaskById(id);
  }

  updateTheTask(id: number, updatedTask: Task): void {
    this.updateTask(id, updatedTask).subscribe({
      next: () => {
        this.navToHome();
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  toggleTaskStatus(tasks: Task[], task: Task): void {
    this.updateTaskStatus(task.id, !task.completed).subscribe({
      next: () => {
        const updatedTasks = tasks.filter(updatedTasks => updatedTasks.id !== task.id);
        tasks.splice(0, tasks.length, ...updatedTasks);
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  addNewTask(task: Omit<Task, "id">): void {
    this.addTask(task).subscribe({
      next: () => {
        this.tasks.push(<Task>task);
        this.navToHome();
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  deleteTaskAndBack(taskId: number): void {
    this.deleteTask(taskId).subscribe({
      next: () => {
        this.navToHome();
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  deleteTaskAndUpdate(tasks: Task[], taskId: number): void {
    this.deleteTask(taskId).subscribe({
      next: () => {
        const updatedTasks = tasks.filter(task => task.id !== taskId);
        tasks.splice(0, tasks.length, ...updatedTasks);
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  navToHome(): void {
    this.router.navigate(['/']).then(r => console.log(r));
  }

  navToAddNewTask(): void {
    this.router.navigate(['/tasks']).then(r => console.log(r));
  }

  navToUpdateTask(taskId: number): void {
    this.router.navigate(['/tasks/update', taskId]).then(r => console.log(r));
  }
}

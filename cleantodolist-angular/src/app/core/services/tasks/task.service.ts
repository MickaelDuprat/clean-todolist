    import { Injectable } from '@angular/core';
    import { HttpClient } from '@angular/common/http';
    import { Observable } from 'rxjs';
    import { Task } from '../../models/task.model';

    @Injectable({
        providedIn: 'root'
    })
    export class TaskService {
        private readonly apiUrl = 'http://localhost:8080/api/tasks';

        constructor(private readonly http: HttpClient) { }

        protected getAllTasks(): Observable<Task[]> {
            return this.http.get<Task[]>(this.apiUrl);
        }

        protected getTaskById(id: number): Observable<Task> {
            return this.http.get<Task>(`${this.apiUrl}/${id}`);
        }

        getAllNotCompletedTasks(): Observable<Task[]> {
            return this.http.get<Task[]>(`${this.apiUrl}/not-completed`);
        }

        protected addTask(task: Omit<Task, 'id'>): Observable<Task> {
            return this.http.post<Task>(this.apiUrl, task);
        }

        protected updateTask(id: number, task: Omit<Task, 'id'>): Observable<Task> {
            return this.http.put<Task>(`${this.apiUrl}/${id}`, task);
        }

        protected updateTaskStatus(id: number, completed: boolean): Observable<Task> {
            return this.http.patch<Task>(`${this.apiUrl}/${id}/completed`, completed);
        }

        protected deleteTask(taskId: number): Observable<void> {
            return this.http.delete<void>(`${this.apiUrl}/${taskId}`);
        }
    }

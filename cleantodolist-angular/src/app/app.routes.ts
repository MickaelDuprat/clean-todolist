import { Routes } from '@angular/router';
import { TaskListComponent } from './features/components/task-list/task-list.component';
import { AddTaskComponent } from './features/components/add-task/add-task.component';
import { UpdateTaskComponent } from "./features/components/update-task/update-task.component";

export const routes: Routes = [
    {
        path: '',
        component: TaskListComponent,
        title: 'Tableau de bord des tâches'
    },
    {
        path: 'tasks/add',
        component: AddTaskComponent,
        title: 'Ajouter une tâche'
    },
    {
        path: 'tasks/update/:id',
        component: UpdateTaskComponent,
        title: 'Modifier une tâche'
    },
    {
        path: '**',
        redirectTo: '',
        pathMatch: 'full'
    }
];

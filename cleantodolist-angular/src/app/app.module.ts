import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';

@NgModule({
    declarations: [

    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        CommonModule,
        RouterModule,
        MatCardModule,
        MatCheckboxModule,
        AppComponent
    ],
    providers: [],
    bootstrap: []
})
export class AppModule { }

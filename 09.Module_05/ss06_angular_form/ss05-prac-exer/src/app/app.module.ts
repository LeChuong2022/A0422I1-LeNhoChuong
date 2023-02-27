import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodoComponent } from './todo/todo.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { RegisterComponent } from './register/register.component';
import { RegisterV2Component } from './register-v2/register-v2.component';
import { RegisterV3Component } from './register-v3/register-v3.component';
import { RegisterV4ReactFormComponent } from './register-v4-react-form/register-v4-react-form.component';
import { RegisterV5CustomValidatorComponent } from './register-v5-custom-validator/register-v5-custom-validator.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    RegisterComponent,
    RegisterV2Component,
    RegisterV3Component,
    RegisterV4ReactFormComponent,
    RegisterV5CustomValidatorComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LoginComponent} from "./login.component";
import {RouterLink} from "@angular/router";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {FormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";



@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    RouterLink,
    MatCheckboxModule,
    FormsModule,
    MatButtonModule
  ]
})
export class LoginModule { }

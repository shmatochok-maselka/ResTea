import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserNavComponent } from './user-nav.component';
import {MatButtonModule} from "@angular/material/button";



@NgModule({
  declarations: [
    UserNavComponent
  ],
  imports: [
    CommonModule,
    MatButtonModule
  ],
  exports: [
    UserNavComponent
  ]
})
export class UserNavModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FilterComponent} from "./filter.component";
import {MatSliderModule} from "@angular/material/slider";
import {MatFormFieldModule} from "@angular/material/form-field";
import {FormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";



@NgModule({
  declarations: [FilterComponent],
  imports: [
    CommonModule,
    MatSliderModule,
    MatFormFieldModule,
    FormsModule,
    MatInputModule
  ],
  exports: [
    FilterComponent
  ]
})
export class FilterModule { }

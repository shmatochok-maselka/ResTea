import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AboutUsPageComponent } from './about-us-page.component';
import {MatButtonModule} from "@angular/material/button";



@NgModule({
  declarations: [
    AboutUsPageComponent
  ],
    imports: [
        CommonModule,
        MatButtonModule
    ],
  exports: [
    AboutUsPageComponent
  ]
})
export class AboutUsPageModule { }

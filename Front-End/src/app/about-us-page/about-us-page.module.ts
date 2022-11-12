import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AboutUsPageComponent } from './about-us-page.component';
import {MatButtonModule} from "@angular/material/button";
import {FlexModule} from "@angular/flex-layout";



@NgModule({
  declarations: [
    AboutUsPageComponent
  ],
    imports: [
        CommonModule,
        MatButtonModule,
        FlexModule
    ],
  exports: [
    AboutUsPageComponent
  ]
})
export class AboutUsPageModule { }

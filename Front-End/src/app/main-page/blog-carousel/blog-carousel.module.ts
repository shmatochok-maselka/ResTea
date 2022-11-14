import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BlogCarouselComponent } from './blog-carousel.component';
import {FlexLayoutModule, FlexModule} from "@angular/flex-layout";
import {MatButtonModule} from "@angular/material/button";


@NgModule({
  declarations: [
    BlogCarouselComponent
  ],
    imports: [
        CommonModule,
        FlexModule,
        MatButtonModule
    ],
  exports: [
    BlogCarouselComponent
  ]
})
export class BlogCarouselModule { }

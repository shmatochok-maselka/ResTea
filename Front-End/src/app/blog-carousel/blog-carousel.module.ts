import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BlogCarouselComponent } from './blog-carousel.component';
import {FlexLayoutModule, FlexModule} from "@angular/flex-layout";


@NgModule({
  declarations: [
    BlogCarouselComponent
  ],
  imports: [
    CommonModule,
    FlexModule
  ],
  exports: [
    BlogCarouselComponent
  ]
})
export class BlogCarouselModule { }

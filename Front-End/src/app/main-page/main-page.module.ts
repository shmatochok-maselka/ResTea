import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainPageComponent } from './main-page.component';
import {SalesCarouselModule} from "./sales-carousel/sales-carousel.module";
import {BlogCarouselModule} from "./blog-carousel/blog-carousel.module";
import {SuggestedItemsModule} from "./suggested-items/suggested-items.module";
import {AboutUsModule} from "./about-us/about-us.module";



@NgModule({
  declarations: [
    MainPageComponent
  ],
  imports: [
    CommonModule,
    SalesCarouselModule,
    BlogCarouselModule,
    AboutUsModule,
    SuggestedItemsModule,
  ],
  exports: [
    MainPageComponent
  ]
})
export class MainPageModule { }

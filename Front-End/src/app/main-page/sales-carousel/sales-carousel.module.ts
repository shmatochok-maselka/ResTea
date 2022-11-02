import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SalesCarouselComponent } from './sales-carousel.component';
import {FlexLayoutModule, FlexModule} from "@angular/flex-layout";


@NgModule({
  declarations: [
    SalesCarouselComponent
  ],
  imports: [
    CommonModule,
    FlexModule,
  ],
  exports: [
    SalesCarouselComponent
  ]
})
export class SalesCarouselModule { }

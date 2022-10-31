import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SuggestedItemsComponent } from './suggested-items.component';



@NgModule({
  declarations: [
    SuggestedItemsComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    SuggestedItemsComponent
  ]
})
export class SuggestedItemsModule { }

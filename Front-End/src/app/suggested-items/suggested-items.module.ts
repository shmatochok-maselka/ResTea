import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SuggestedItemsComponent } from './suggested-items.component';
import {MatCardModule} from '@angular/material/card';


@NgModule({
  declarations: [
    SuggestedItemsComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
  ],
  exports: [
    SuggestedItemsComponent
  ]
})
export class SuggestedItemsModule { }

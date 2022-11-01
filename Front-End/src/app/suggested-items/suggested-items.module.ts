import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SuggestedItemsComponent } from './suggested-items.component';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {FlexLayoutModule, FlexModule} from "@angular/flex-layout";

@NgModule({
  declarations: [
    SuggestedItemsComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatGridListModule,
    FlexModule,
  ],
  exports: [
    SuggestedItemsComponent
  ]
})
export class SuggestedItemsModule { }

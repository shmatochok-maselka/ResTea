import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SuggestedItemsComponent } from './suggested-items.component';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {FlexLayoutModule, FlexModule} from "@angular/flex-layout";
import {ProductCardModule} from "./product-card/product-card.module";

@NgModule({
  declarations: [
    SuggestedItemsComponent
  ],
    imports: [
        CommonModule,
        MatCardModule,
        MatGridListModule,
        FlexModule,
        ProductCardModule,
    ],
  exports: [
    SuggestedItemsComponent
  ]
})
export class SuggestedItemsModule { }

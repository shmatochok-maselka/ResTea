import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SuggestedItemsComponent} from './suggested-items.component';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {ProductModule} from "../../shop/product/product.module";

@NgModule({
  declarations: [
    SuggestedItemsComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatGridListModule,
    ProductModule,
  ],
  exports: [
    SuggestedItemsComponent
  ]
})
export class SuggestedItemsModule {
}

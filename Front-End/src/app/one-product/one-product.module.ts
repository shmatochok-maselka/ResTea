import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OneProductComponent } from './one-product.component';



@NgModule({
  declarations: [
    OneProductComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    OneProductComponent
  ]
})
export class OneProductModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OneProductComponent } from './one-product.component';
import {MatButtonModule} from '@angular/material/button';


@NgModule({
  declarations: [
    OneProductComponent
  ],
  imports: [
    CommonModule,
    MatButtonModule
  ],
  exports: [
    OneProductComponent
  ]
})
export class OneProductModule { }

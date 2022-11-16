import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OneProductComponent } from './one-product.component';
import {MatButtonModule} from '@angular/material/button';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    OneProductComponent
  ],
    imports: [
        CommonModule,
        MatButtonModule,
        FormsModule
    ],
  exports: [
    OneProductComponent
  ]
})
export class OneProductModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CatalogComponent} from "./catalog.component";
import {ProductModule} from "../product/product.module";
import {MatGridListModule} from "@angular/material/grid-list";



@NgModule({
  declarations: [CatalogComponent],
  imports: [
    CommonModule,
    ProductModule,
    MatGridListModule
  ],
  exports:[CatalogComponent]
})
export class CatalogModule { }

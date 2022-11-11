import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ShopComponent} from "./shop.component";
import {FilterModule} from "./filter/filter.module";
import {CatalogModule} from "./catalog/catalog.module";



@NgModule({
  declarations: [ShopComponent],
  imports: [
    CommonModule,
    FilterModule,
    CatalogModule,
  ],
  exports:[ShopComponent]
})
export class ShopModule { }

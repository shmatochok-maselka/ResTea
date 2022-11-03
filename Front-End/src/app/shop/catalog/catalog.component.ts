import {Component, OnInit} from '@angular/core';
import {Product} from "../../models/product";
import {ProductService} from "../../config/product.service"

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  products: Product[] = [
  ];

  constructor(private _productService:ProductService) {

  }

  ngOnInit(): void {
    this._productService.getProducts().subscribe(x=>x.forEach(el=>this.products.push(el)));
  }

}

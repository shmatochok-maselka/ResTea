import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Product} from "../models/product";
import {ProductService} from "../config/product.service";

@Component({
  selector: 'app-one-product',
  templateUrl: './one-product.component.html',
  styleUrls: ['./one-product.component.css']
})
export class OneProductComponent implements OnInit {

  constructor(private route: ActivatedRoute, private _productService: ProductService) {
  }

  id: number = 0;
  product: Product = {
    id: 0,
    description: '',
    name: '',
    origin: {id: 0, name: ''},
    type: {id: 0, name: ''},
    flavors: [],
    properties: [],
    price: 0,
    image: ''
  };
  flavorsNames:Array<string>=[];
  propertiesNames:Array<string>=[];

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id']
    })
    this._productService.getOneProduct(this.id).subscribe(el => {
      this.product = el;
      this.product.flavors.forEach(el=>this.flavorsNames.push(el.name))
      this.product.properties.forEach(el=>this.propertiesNames.push(el.name))
      console.log(this.product)
    });
  }
}

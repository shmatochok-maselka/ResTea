import { Component, Input, OnInit } from '@angular/core';
import {Product} from "../../models/product";

@Component({
  selector: 'app-cart-product',
  templateUrl: './cart-product.component.html',
  styleUrls: ['./cart-product.component.css']
})
export class CartProductComponent implements OnInit {
  cartProduct: Product = {
    id: 0,
    name: '',
    description: '',
    price: 0,
    image: '',
    type: {id: 0, name: ''},
    origin: {id: 0, name: ''},
    flavors: [],
    properties: []
  };

  constructor() { }

  ngOnInit(): void {
  }

}

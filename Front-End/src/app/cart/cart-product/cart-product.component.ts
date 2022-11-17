import {Component, Input, OnInit} from '@angular/core';

import {CartProduct} from "../../models/cart-product";

@Component({
  selector: 'app-cart-product',
  templateUrl: './cart-product.component.html',
  styleUrls: ['./cart-product.component.css']
})
export class CartProductComponent implements OnInit {
  @Input() cartProduct: CartProduct = {
    product: {
      id: 0,
      name: '',
      description: '',
      price: 0,
      image: '',
      type: {id: 0, name: ''},
      origin: {id: 0, name: ''},
      flavors: [],
      properties: []
    },
    productWeight: 0
  };

  constructor() {
  }

  ngOnInit(): void {
  }

}

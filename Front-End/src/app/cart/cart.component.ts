import {Component, OnInit} from '@angular/core';
import {CartProduct} from "../models/cart-product";
import {CartService} from "../config/cart.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  products: CartProduct[] = [];

  constructor(private _cartService: CartService) {
  }

  ngOnInit(): void {
    this._cartService.getCart().subscribe(x=>{
      x.forEach(el=> this.products.push(el))
    })
  }

}

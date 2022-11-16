import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Product} from "../models/product";
import {ProductService} from "../config/product.service";
import {CartService} from "../config/cart.service";

@Component({
  selector: 'app-one-product',
  templateUrl: './one-product.component.html',
  styleUrls: ['./one-product.component.css']
})
export class OneProductComponent implements OnInit {

  constructor(private route: ActivatedRoute, private _productService: ProductService, private _cartService:CartService){
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

  mass: number=50;
  price:number=this.mass*this.product.price;

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id']
    })
    this._productService.getOneProduct(this.id).subscribe(el => {
      this.product = el;
      this.product.flavors.forEach(el=>this.flavorsNames.push(el.name))
      this.product.properties.forEach(el=>this.propertiesNames.push(el.name))
    });

  }
  ngDoCheck(): void{
    this.price=this.mass*this.product.price
  }

  setPrice() {
    this.price=this.mass*this.product.price
  }

  addToCart() {
    this._cartService.addProduct(this.id, this.mass).subscribe()
    this._cartService.getCart().subscribe(x=>console.log(x))
  }
}

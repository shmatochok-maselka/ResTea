import {Component, Input, OnInit} from '@angular/core';
import {Product} from "../../models/product";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() products: Product = {
    id: 0,
    name: '',
    description: '',
    price: 0,
    image: '',
    type: {id:0,name:''},
    origin: {id:0,name:''},
    flavors:[],
    properties:[]
  };

  constructor() { }

  ngOnInit(): void {
  }

}

import {Component, OnInit, Input} from '@angular/core';
import {Product} from "../../../models/product";


@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {
  @Input() product: Product = {
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
  constructor() {
  }

  ngOnInit()
    :
    void {
  }

}

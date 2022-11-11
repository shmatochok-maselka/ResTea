import {Component, OnInit, Input} from '@angular/core';

interface item {
  itemImageSrc: string;
  itemImageAlt: string;
  itemName: string;
  itemPrice: string;
  itemLink: string;
}

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {
  @Input() items: item = {
    itemImageSrc: "",
    itemImageAlt: "",
    itemName: "",
    itemPrice: "",
    itemLink: "",
  }

  constructor() {
  }

  ngOnInit()
    :
    void {
  }

}

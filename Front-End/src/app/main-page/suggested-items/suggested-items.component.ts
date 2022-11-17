import {Component, OnInit, Input} from '@angular/core';
import {Product} from "../../models/product";


@Component({
  selector: 'app-suggested-items',
  templateUrl: './suggested-items.component.html',
  styleUrls: ['./suggested-items.component.css']
})
export class SuggestedItemsComponent implements OnInit {
  @Input() items: Product[] = []

  constructor() {
  }

  ngOnInit(): void {
  }

}

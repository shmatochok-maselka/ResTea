import {Component, OnInit, Input} from '@angular/core';

interface item {
  itemImageSrc: string;
  itemImageAlt: string;
  itemName: string;
  itemPrice: string;
  itemLink: string;
}

@Component({
  selector: 'app-suggested-items',
  templateUrl: './suggested-items.component.html',
  styleUrls: ['./suggested-items.component.css']
})
export class SuggestedItemsComponent implements OnInit {
  @Input() items: item[] = []

  constructor() {
  }

  ngOnInit(): void {
  }

}

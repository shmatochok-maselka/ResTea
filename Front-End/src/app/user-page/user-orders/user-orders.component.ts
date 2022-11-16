import {Component, Input, OnInit} from '@angular/core';

interface orders {
  Id: string;
  Date: string;
  Sum: string;
}

@Component({
  selector: 'app-user-orders',
  templateUrl: './user-orders.component.html',
  styleUrls: ['./user-orders.component.css']
})
export class UserOrdersComponent implements OnInit {
  @Input() orders: orders [] = [];

  constructor() {
  }

  ngOnInit(): void {
  }

}

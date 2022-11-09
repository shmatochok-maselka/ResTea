import { Component, OnInit } from '@angular/core';
import {FilterParamsModel} from "../models/categories";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {
  filterParameters:FilterParamsModel={type:[], origin:[], flavor:[], property:[], name:""};

  constructor() { }

  ngOnInit(): void {
  }


  onFilterChange(filterModel: FilterParamsModel) {
    this.filterParameters=filterModel;
  }
}

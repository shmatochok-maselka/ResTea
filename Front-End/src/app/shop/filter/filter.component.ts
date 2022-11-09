import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {EntityFilterModel, FilterParamsModel, Flavor, Origin, Property, Type} from "../../models/categories";
import {CategoryService} from "../../config/category.service";
import {FilterTypes} from "./model";


@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {
  _name: string = "";
  types: EntityFilterModel<Type>[] = [];
  origins: EntityFilterModel<Origin>[] = [];
  flavors: EntityFilterModel<Flavor>[] = [];
  properties: EntityFilterModel<Property>[] = [];
  filtersObject: FilterParamsModel = {type: [], origin: [], flavor: [], property: [], name: ""};
  @Output() filterChange = new EventEmitter<FilterParamsModel>();
  price: number = 50;
  max_value: number = 100;

  constructor(private _categoryService: CategoryService,) {
  }

  ngOnInit(): void {
    this._categoryService.getCategories().subscribe(x => x.typeCategory.forEach((el: Type) => this.types.push({
      value: el,
      checked: true
    })));
    this._categoryService.getCategories().subscribe(x => x.originCategory.forEach((el: Type) => this.origins.push({
      value: el,
      checked: true
    })));
    this._categoryService.getCategories().subscribe(x => x.flavorCategory.forEach((el: Type) => this.flavors.push({
      value: el,
      checked: true
    })));
    this._categoryService.getCategories().subscribe(x => x.propertyCategory.forEach((el: Type) => this.properties.push({
      value: el,
      checked: true
    })));
  }

  OnChange($event: Event): void {
    this.updateFilterObject();
    this.filterChange.emit(this.filtersObject);
  }

  private updateFilterObject() {
    this.filtersObject = {type: [], origin: [], flavor: [], property: [], name: ""};
    this.types.forEach(el => {
      if (el.checked) this.filtersObject.type.push(el.value.id)
    })
    this.origins.forEach(el => {
      if (el.checked) this.filtersObject.origin.push(el.value.id)
    })
    this.flavors.forEach(el => {
      if (el.checked) this.filtersObject.flavor.push(el.value.id)
    })
    this.properties.forEach(el => {
      if (el.checked) this.filtersObject.property.push(el.value.id)
    })
    this.filtersObject.name = this._name;
  }
}

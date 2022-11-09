import {Component, EventEmitter, Input, OnInit} from '@angular/core';
import {Product} from "../../models/product";
import {ProductService} from "../../config/product.service"
import {EntityFilterModel, FilterParamsModel, Flavor, Type} from "../../models/categories";
import {filter, Subscription} from "rxjs";

function ContainSome(arr1: number[], arr2: Flavor[]): boolean {
  if (arr2.length==0) return true
  for(let i=0; i<arr2.length;i++){
    if ((arr1.includes(arr2[i].id))||(arr2==[])) return true;
  }
  return false;
}

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  allProducts: Product[] = [];
  products: Product[] = [];
  breakpoint: number | undefined;
  private _filters: FilterParamsModel={type:[],origin:[],flavor:[],property:[],name:""};
  @Input() filterChange = new EventEmitter<FilterParamsModel>();
  dataSubscription: Subscription | undefined;

  constructor(private _productService: ProductService) {

  }

  ngOnInit(): void {
    this._productService.getProducts().subscribe(x => {
      x.forEach(el => this.allProducts.push(el));
      this.products = this.allProducts;
    });
    if (window.innerWidth < 768) this.breakpoint = 2;
    else if (window.innerWidth < 1070) this.breakpoint = 3
    else this.breakpoint = 4;
  }

  onResize($event: any) {
    if (window.innerWidth < 768) this.breakpoint = 2;
    else if (window.innerWidth < 1070) this.breakpoint = 3;
    else this.breakpoint = 4;
  }
  @Input() set filters(value: FilterParamsModel) {
    this._filters=value;
    this.products = [];
    this.allProducts.forEach(el => {
        if (this._filters.type.includes(el.type.id) &&
          this._filters.origin.includes(el.origin.id) &&
          ContainSome(this._filters.flavor,el.flavors) &&
          ContainSome(this._filters.flavor,el.flavors) &&
          el.name.includes(this._filters.name))
          this.products.push(el)
      }
    )
  }

}

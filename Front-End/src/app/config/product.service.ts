import {Injectable} from '@angular/core';
import {Product} from "../models/product";
import {Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';
import {apiUrl} from "../../assets/apiurl";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private productsUrl = `${apiUrl}/products`;

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productsUrl)
  }

  getOneProduct(id:number):Observable<Product>{
    return this.http.get<Product>(`${this.productsUrl}/${id}`)
  }

  constructor(
    private http: HttpClient) {
  }
}

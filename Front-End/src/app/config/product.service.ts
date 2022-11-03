import {Injectable} from '@angular/core';
import {Product} from "../models/product";
import {Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private heroesUrl = 'http://localhost:8080/api/v1/products';

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.heroesUrl)
  }

  constructor(
    private http: HttpClient) {
  }
}

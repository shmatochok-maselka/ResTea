import { Injectable } from '@angular/core';
import {HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {apiUrl} from "../../assets/apiurl";
import {HttpClient} from "@angular/common/http";
import {CartProduct} from "../models/cart-product";

@Injectable({
  providedIn: 'root'
})
export class CartService {
  constructor(private http: HttpClient) {}

  private cartUrl = `${apiUrl}/cart`;
  private userToken = localStorage.getItem('token');
  private headers = new HttpHeaders(
    {'Authorization': `Bearer ${this.userToken}`,
      'Access-Control-Allow-Origin' : '*'
  })

  getCart():Observable<CartProduct[]>{
    const options = {headers: this.headers};
    return this.http.get<any>(this.cartUrl, options)

  }
  addProduct(id:number, weight:number ): Observable<any> {
    const options = {headers: this.headers};
    return this.http.post<any>(`${this.cartUrl}/add`,{"productId":id,"productWeight":weight},options)
  }
}


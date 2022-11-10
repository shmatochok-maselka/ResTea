import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private categoriesUrl = 'http://localhost:8080/api/v1/categories';

  getCategories(): Observable<any> {
    return this.http.get<any>(this.categoriesUrl)
  }
  getPrice():Observable<any>{
    return  this.http.get<any>(`${this.categoriesUrl}/max_min_price`)
  }

  constructor(private http: HttpClient) {}
  }

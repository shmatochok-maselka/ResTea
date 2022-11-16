import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {apiUrl} from "../../assets/apiurl"
@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  constructor(private http: HttpClient) {}

  private categoriesUrl = `${apiUrl}/categories`;

  getCategories(): Observable<any> {
    return this.http.get<any>(this.categoriesUrl)
  }

  getPrice(): Observable<any> {
    return this.http.get<any>(`${this.categoriesUrl}/max_min_price`)
  }


}

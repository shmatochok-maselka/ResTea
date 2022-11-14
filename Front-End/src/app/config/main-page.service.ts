import { Injectable } from '@angular/core';
import {apiUrl} from "../../assets/apiurl";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MainPageService {
  private mainPageUrl=`${apiUrl}/main_page`
  getMainPage():Observable<any> {
    return this.http.get<any>(this.mainPageUrl)
  }

  constructor(private http: HttpClient) { }
}

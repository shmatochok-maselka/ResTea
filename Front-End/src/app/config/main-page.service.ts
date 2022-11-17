import { Injectable } from '@angular/core';
import {apiUrl} from "../../assets/apiurl";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../models/product";
import {BlogPost} from "../models/blog-post";

@Injectable({
  providedIn: 'root'
})
export class MainPageService {
  private mainPageUrl=`${apiUrl}/main_page`

  getMainPage():Observable<any> {
    return this.http.get<{products:Product[],blogPosts:BlogPost[]}>(this.mainPageUrl)
  }

  constructor(private http: HttpClient) { }
}

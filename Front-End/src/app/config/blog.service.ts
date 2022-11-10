import {Injectable} from '@angular/core';
import {apiUrl} from "../../assets/apiurl";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BlogService {
  private blogUrl = `${apiUrl}/blog`;

  getPost(): Observable<any> {
    return this.http.get<any>(this.blogUrl)
  }

  constructor(private http: HttpClient) {
  }
}

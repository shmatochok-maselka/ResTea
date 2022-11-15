import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {MatSnackBar} from "@angular/material/snack-bar";
import {LoginResponseI, User} from "../models/user"
import {catchError, Observable, tap, throwError} from "rxjs";
import {apiUrl} from "../../assets/apiurl";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private loginUrl = `${apiUrl}/login`;
  private headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded',
    'Access-Control-Allow-Origin' : '*'});

  constructor(private http: HttpClient, private snackbar: MatSnackBar) {

  }

  create(user: User): Observable<User> {
    return this.http.post<User>(`${apiUrl}/users`, user).pipe(
      tap((createdUser: User) => this.snackbar.open(`User ${createdUser.email} created`,
        `Close`, {duration: 2000, horizontalPosition: "right", verticalPosition: "bottom"}
      )),
      catchError(e => {
        this.snackbar.open(`User could not be created, ${e.error.message}`, 'Close', {
          duration: 2000,
          horizontalPosition: "right",
          verticalPosition: "bottom"
        })
        return throwError(e);
      })
    )
  }

  login(email:string, password:string):Observable<LoginResponseI> {
    const body = new HttpParams().set('email',email).set('password',password)
    const options = {headers: this.headers};
    return this.http.post<LoginResponseI>(this.loginUrl, body.toString(), options).pipe(
      tap((res:LoginResponseI)=> localStorage.setItem('token',res.access_token)),
      tap(()=>this.snackbar.open("Login Succesful", 'Close',
        {duration: 2000, horizontalPosition: "right", verticalPosition: "bottom"})))
  }
}

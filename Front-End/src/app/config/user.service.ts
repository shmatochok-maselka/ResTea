import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MatSnackBar} from "@angular/material/snack-bar";
import {User} from "../models/user"
import {catchError, Observable, tap, throwError} from "rxjs";
import {apiUrl} from "../../assets/apiurl";

@Injectable({
  providedIn: 'root'
})
export class UserService {

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
}

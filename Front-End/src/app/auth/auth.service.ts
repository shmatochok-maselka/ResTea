import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private isAuth:boolean=false;
  constructor() {
  }
  isAuthenticated():Promise<boolean>{
    this.isAuth=(localStorage.getItem('token')!==null)
    console.log(localStorage.getItem('token'))
    return new Promise(resolve => resolve(this.isAuth))
  }
}

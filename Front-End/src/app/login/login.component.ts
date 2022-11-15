import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../config/user.service";
import {LoginUserI} from "../models/user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  checked: any;
  form: FormGroup= new FormGroup({
    email: new FormControl(null, [Validators.required, Validators.email]),
    password: new FormControl(null, [Validators.required])
  }
  )
  loginData:LoginUserI={email:'',password:''}

  constructor(private _userService:UserService) { }

  get email(): FormControl{
    return  this.form.get('email') as FormControl;
  }

  get password(): FormControl{
    return  this.form.get('password') as FormControl;
  }

  login(){
    if (this.form.valid){
     this._userService.login(this.email.value, this.password.value).subscribe()
    }
  }

}

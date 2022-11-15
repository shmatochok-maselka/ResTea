import {Component} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../config/user.service";
import {LoginUserI} from "../models/user";
import {Router} from "@angular/router";
import {tap} from "rxjs";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  checked: any;
  form: FormGroup = new FormGroup({
      email: new FormControl(null, [Validators.required, Validators.email]),
      password: new FormControl(null, [Validators.required])
    }
  )

  constructor(private _userService: UserService, private router: Router) {
  }

  get email(): FormControl {
    return this.form.get('email') as FormControl;
  }

  get password(): FormControl {
    return this.form.get('password') as FormControl;
  }

  login() {
    if (this.form.valid) {
      this._userService.login(this.email.value, this.password.value).pipe(
        tap(() => this.router.navigate(["../"]))).subscribe()
    }
  }

}

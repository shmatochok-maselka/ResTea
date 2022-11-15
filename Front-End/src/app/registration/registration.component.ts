import {Component} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomValidatorService} from "../config/custom-validator.service";
import {UserService} from "../config/user.service";
import {Router} from "@angular/router";
import {tap} from "rxjs";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent  {

  form: FormGroup = new FormGroup({
    email: new FormControl(null, [Validators.required, Validators.email]),
    patronymic: new FormControl(null, [Validators.required]),
    password: new FormControl(null, [Validators.required]),
    passwordConfirm: new FormControl(null, [Validators.required]),
    name:new FormControl(null, [Validators.required]),
    surname: new FormControl(null, [Validators.required]),
    birthday: new FormControl(null, [Validators.required]),
  },
    {
      validators:[ CustomValidatorService.passwordsMatching,
       CustomValidatorService.rightBirthday]
  })

  get patronymic(): FormControl{
    return this.form.get('patronymic') as FormControl
  }

  get email(): FormControl{
    return this.form.get('email') as FormControl
  }

  get password(): FormControl{
    return this.form.get('password') as FormControl
  }

  get passwordConfirm(): FormControl{
    return this.form.get('passwordConfirm') as FormControl
  }

  get name(): FormControl{
    return this.form.get('name') as FormControl
  }

  get surname(): FormControl{
    return this.form.get('surname') as FormControl
  }
  get birthday(): FormControl{
    return this.form.get('birthday') as FormControl
  }

  constructor(private _userService:UserService, private router:Router) {
  }

  register() {
    if(this.form.valid){
      this._userService.create({
        name:this.name.value,
        surname:this.surname.value,
        patronymic:this.patronymic.value,
        email:this.email.value,
        birthday:this.birthday.value,
        password:this.password.value,
      }).pipe(tap(()=>this.router.navigate(['../login']))).subscribe()
    }
  }
}

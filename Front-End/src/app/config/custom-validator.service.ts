import { AbstractControl, ValidationErrors } from "@angular/forms";

function getAge(DOB: Date) {
  const today = new Date();
  const birthDate = new Date(DOB);
  let age = today.getFullYear() - birthDate.getFullYear();
  const m = today.getMonth() - birthDate.getMonth();
  if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
    age--;
  }
  return age;
}

export class CustomValidatorService {
  static passwordsMatching(control: AbstractControl): ValidationErrors | null {
    const password = control.get('password')?.value;
    const passwordConfirm = control.get('passwordConfirm')?.value;
    if ((password === passwordConfirm) && (password !== null)) {
      return null;
    } else {
      return { passwordsNotMatching: true };
    }


  }
  static rightBirthday(control: AbstractControl): ValidationErrors | null{
    const birthday:Date = control.get('birthday')?.value;
    if (getAge(birthday)>=14){
      return null;
    }
    else {
      return {wrongBirthday: true}
    }
  }

}

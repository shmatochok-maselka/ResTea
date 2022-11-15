export interface User{
  name:string,
  surname:string,
  patronymic:string,
  birthday: Date,
  email:string,
  password:string
}
export interface LoginResponseI{
  access_token: string
}

export interface LoginUserI{
  email:string;
  password:string;
}

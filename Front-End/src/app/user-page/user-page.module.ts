import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserPageComponent } from './user-page.component';
import {UserNavModule} from "./user-nav/user-nav.module";
import {UserProfileModule} from "./user-profile/user-profile.module";



@NgModule({
  declarations: [
    UserPageComponent
  ],
  imports: [
    CommonModule,
    UserNavModule,
    UserProfileModule,
  ],
  exports: [
    UserPageComponent
  ]
})
export class UserPageModule { }

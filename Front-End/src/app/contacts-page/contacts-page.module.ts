import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactsPageComponent } from './contacts-page.component';
import {MatListModule} from "@angular/material/list";
import {MatIconModule} from "@angular/material/icon";
import {FlexModule} from "@angular/flex-layout";



@NgModule({
  declarations: [
    ContactsPageComponent
  ],
    imports: [
        CommonModule,
        MatListModule,
        MatIconModule,
        FlexModule
    ],
  exports: [
    ContactsPageComponent
  ]
})
export class ContactsPageModule { }

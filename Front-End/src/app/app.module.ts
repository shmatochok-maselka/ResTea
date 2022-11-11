import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { BlogComponent } from './blog/blog.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MainPageModule} from "./main-page/main-page.module";
import {NavBarModule} from "./nav-bar/nav-bar.module";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {OneProductModule} from "./one-product/one-product.module";


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    BlogComponent,
  ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        MainPageModule,
        NavBarModule,
        MatIconModule,
        MatButtonModule,
        OneProductModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

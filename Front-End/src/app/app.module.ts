import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';0
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MainPageModule} from "./main-page/main-page.module";
import {NavBarModule} from "./nav-bar/nav-bar.module";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {AppRoutingModule} from "./app-routing.module";
import {MatCardModule} from "@angular/material/card";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatInputModule} from "@angular/material/input";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {FormsModule} from "@angular/forms";
import {MatSliderModule} from "@angular/material/slider";
import {ShopModule} from "./shop/shop.module";
import {RouterLink, RouterModule} from "@angular/router";
import {OneProductModule} from "./one-product/one-product.module";
import {AboutUsPageModule} from "./about-us-page/about-us-page.module";
import {ContactsPageModule} from "./contacts-page/contacts-page.module";
import {LoginModule} from "./login/login.module";
import {RegistrationModule} from "./registration/registration.module";
import {JwtModule} from "@auth0/angular-jwt";
import {BlogModule} from "./blog/blog.module";
import {UserPageModule} from "./user-page/user-page.module";

export function tokenGetter(){
  return localStorage.getItem("token")
}

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
  ],
    imports: [
        OneProductModule,
        RouterLink,
        RouterModule,
        ShopModule,
        BrowserModule,
        BrowserAnimationsModule,
        MainPageModule,
        NavBarModule,
        MatIconModule,
        MatButtonModule,
        MatCardModule,
        MatGridListModule,
        HttpClientModule,
        MatInputModule,
        MatCheckboxModule,
        FormsModule,
        MatSliderModule,
        AppRoutingModule,
        AboutUsPageModule,
        ContactsPageModule,
        LoginModule,
        RegistrationModule,
        BlogModule,
        JwtModule.forRoot({
          config:{
            tokenGetter:tokenGetter,
            allowedDomains:['localhost:4020']
      }
        })
    ],
  providers: [],
  exports: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}

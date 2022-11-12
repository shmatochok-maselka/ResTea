import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { BlogComponent } from './blog/blog.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MainPageModule} from "./main-page/main-page.module";
import {NavBarModule} from "./nav-bar/nav-bar.module";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {AppRoutingModule} from "./app-routing.module";
import {BlogPostComponent} from './blog/blog-post/blog-post.component';
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

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    BlogComponent,
    BlogPostComponent,
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
    ],
  providers: [],
  exports: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}

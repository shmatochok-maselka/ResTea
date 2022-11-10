import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";

import {AppRoutingModule} from "./app-routing/app-routing.module";
import {AppComponent} from './app.component';
import {NavBarComponent} from './nav-bar/nav-bar.component';
import {BlogComponent} from './blog/blog.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {ShopComponent} from './shop/shop.component';
import {FilterComponent} from './shop/filter/filter.component';
import {ProductComponent} from './shop/product/product.component';
import {CatalogComponent} from './shop/catalog/catalog.component';
import {BlogPostComponent} from './blog/blog-post/blog-post.component';
import {MatCardModule} from "@angular/material/card";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatInputModule} from "@angular/material/input";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {FormsModule} from "@angular/forms";
import {MatSliderModule} from "@angular/material/slider";

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    BlogComponent,
    ShopComponent,
    FilterComponent,
    ProductComponent,
    CatalogComponent,
    BlogPostComponent
  ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        MatIconModule,
        MatButtonModule,
        MatCardModule,
        MatGridListModule,
        HttpClientModule,
        MatInputModule,
        MatCheckboxModule,
        FormsModule,
        MatSliderModule,
        AppRoutingModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

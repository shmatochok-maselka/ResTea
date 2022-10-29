import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { BlogComponent } from './blog/blog.component';
import {SalesCarouselModule} from "./sales-carousel/sales-carousel.module";

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    BlogComponent
  ],
  imports: [
    BrowserModule,
    SalesCarouselModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

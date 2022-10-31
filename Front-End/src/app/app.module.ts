import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { BlogComponent } from './blog/blog.component';
import {SalesCarouselModule} from "./sales-carousel/sales-carousel.module";
import {BlogCarouselModule} from "./blog-carousel/blog-carousel.module";
import {SuggestedItemsModule} from "./suggested-items/suggested-items.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    BlogComponent,
  ],
  imports: [
    BrowserModule,
    SalesCarouselModule,
    BlogCarouselModule,
    SuggestedItemsModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

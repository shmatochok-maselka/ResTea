import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BlogPostPageComponent} from "./blog-post-page.component";



@NgModule({
  declarations: [BlogPostPageComponent],
  imports: [
    CommonModule
  ],
  exports:[BlogPostPageComponent]
})
export class BlogPostPageModule { }

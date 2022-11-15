import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BlogPostComponent} from "./blog-post.component";



@NgModule({
  declarations: [BlogPostComponent],
  imports: [
    CommonModule
  ],
  exports:[BlogPostComponent]
})
export class BlogPostModule { }

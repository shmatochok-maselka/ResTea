import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BlogPostComponent} from "./blog-post.component";
import {RouterLink} from "@angular/router";
import {MatButtonModule} from "@angular/material/button";



@NgModule({
  declarations: [BlogPostComponent],
  imports: [
    CommonModule,
    RouterLink,
    MatButtonModule
  ],
  exports:[BlogPostComponent],
})
export class BlogPostModule { }

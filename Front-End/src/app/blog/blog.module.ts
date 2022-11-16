import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BlogComponent} from "./blog.component";
import {BlogPostPageModule} from "./blog-post-page/blog-post-page.module";
import {BlogPostModule} from "./blog-post/blog-post.module";




@NgModule({
  declarations: [
      BlogComponent,

    ],
    imports: [
      BlogPostModule,
      BlogPostPageModule,
      CommonModule
    ],
    exports:[BlogComponent]
  })
export class BlogModule { }

import {Component, OnInit} from '@angular/core';
import {BlogPost} from "../models/blog-post";
import {BlogService} from "../config/blog.service";

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {
  blogPosts: BlogPost[] = [];

  constructor(private _blogService: BlogService) {
  }

  ngOnInit(): void {
    this._blogService.getPost().subscribe(posts =>
      posts.forEach((el: BlogPost) => this.blogPosts.push(el)))
    console.log(this.blogPosts)
  }

}

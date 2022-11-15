import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Product} from "../../models/product";
import {BlogService} from "../../config/blog.service";
import {BlogPost} from "../../models/blog-post";

@Component({
  selector: 'app-blog-post-page',
  templateUrl: './blog-post-page.component.html',
  styleUrls: ['./blog-post-page.component.css']
})
export class BlogPostPageComponent implements OnInit {

  constructor(private route: ActivatedRoute, private _blogService: BlogService) {
  }

  id: number = 0;
  post: BlogPost = {
    id: 0,
    title:'',
    content:'',
    image: ''
  };

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id']
    })
    this._blogService.getOnePost(this.id).subscribe(el => {
      this.post = el;
      console.log(this.post)
    });
  }
}

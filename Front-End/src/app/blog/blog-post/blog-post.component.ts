import {Component, Input, OnInit} from '@angular/core';
import {BlogPost} from "../../models/blog-post";

@Component({
  selector: 'app-blog-post',
  templateUrl: './blog-post.component.html',
  styleUrls: ['./blog-post.component.css']
})
export class BlogPostComponent implements OnInit {
  @Input() blogPost: BlogPost= { title:  '',
  id:0,
  content: '',
  image:'',
}


  constructor() {
  }

  ngOnInit(): void {
  }

}

import {Component, OnInit, Input} from '@angular/core';

interface postComponents {
  imageSrc: string;
  imageAlt: string;
  postHeader: string;
  postText: string;
  postLink: string;
}

@Component({
  selector: 'app-blog-carousel',
  templateUrl: './blog-carousel.component.html',
  styleUrls: ['./blog-carousel.component.css']
})
export class BlogCarouselComponent implements OnInit {
  @Input() posts: postComponents[] = []

  constructor() {
  }

  selectedIndex = 0;

  ngOnInit(): void {
  }

}

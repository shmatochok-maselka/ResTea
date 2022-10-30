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
  @Input() indicators = false;
  @Input() controls = true;

  constructor() {
  }

  selectedIndex = 0;

  ngOnInit(): void {
  }

  selectPost(index: number): void {
    this.selectedIndex = index;
  }

  onPrevClick(): void {
    if (this.selectedIndex === 0) {
      this.selectedIndex = this.posts.length - 1;
    } else {
      this.selectedIndex--;
    }
  }

  onNextClick(): void {
    if (this.selectedIndex === this.posts.length - 1) {
      this.selectedIndex = 0;
    } else {
      this.selectedIndex++;
    }
  }
}

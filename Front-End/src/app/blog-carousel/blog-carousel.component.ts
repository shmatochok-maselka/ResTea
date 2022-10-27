import {Component, Input, OnInit} from '@angular/core';

interface carouseleImages {
  imageSrc: string;
  imageAlt: string;
}

@Component({
  selector: 'app-blog-carousel',
  templateUrl: './blog-carousel.component.html',
  styleUrls: ['./blog-carousel.component.css']
})
export class BlogCarouselComponent implements OnInit {
  @Input() images: carouseleImages[] = [];
  @Input() indicators = true;
  @Input() controls = true;

  constructor() {
  }

  ngOnInit(): void {
  }

  selectedIndex = 0;

  selectImage(index: number): void {
    this.selectedIndex = index;
  }

  onPrevClick(): void {
    if (this.selectedIndex === 0) {
      this.selectedIndex = this.images.length - 1;
    } else {
      this.selectedIndex--;
    }
  }

  onNextClick(): void {
    if(this.selectedIndex===this.images.length - 1){
      this.selectedIndex = 0;
    } else {
      this.selectedIndex++;
    }
  }
}

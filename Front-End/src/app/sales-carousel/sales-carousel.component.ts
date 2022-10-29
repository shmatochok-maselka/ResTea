import {Component, Input, OnInit} from '@angular/core';

interface carouseleImages {
  imageSrc: string;
  imageAlt: string;
}

@Component({
  selector: 'app-sales-carousel',
  templateUrl: './sales-carousel.component.html',
  styleUrls: ['./sales-carousel.component.css']
})
export class SalesCarouselComponent implements OnInit {
  @Input() images: carouseleImages[] = [];
  @Input() indicators = true;
  @Input() controls = true;
  @Input() autoSlide = false;
  @Input() slideInterval = 5000;

  constructor() {
  }

  ngOnInit(): void {
    if (this.autoSlide) {
      this.autoSlideImages()
    }
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
    if (this.selectedIndex === this.images.length - 1) {
      this.selectedIndex = 0;
    } else {
      this.selectedIndex++;
    }
  }

  autoSlideImages(): void {
    setInterval(() => {
      this.onNextClick();
    }, this.slideInterval)
  }
}

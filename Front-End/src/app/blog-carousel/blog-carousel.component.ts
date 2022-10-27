import {Component, Input, OnInit} from '@angular/core';

interface carouseleImages{
  imageSrc:string;
  imageAlt:string;
}

@Component({
  selector: 'app-blog-carousel',
  templateUrl: './blog-carousel.component.html',
  styleUrls: ['./blog-carousel.component.css']
})
export class BlogCarouselComponent implements OnInit {
  @Input() images: carouseleImages[] = [];
  @Input() indicators = true;
  constructor() { }

  ngOnInit(): void {
  }

  selectedIndex = 0;

  selectImage(index:number):void{
    this.selectedIndex = index;
  }
}

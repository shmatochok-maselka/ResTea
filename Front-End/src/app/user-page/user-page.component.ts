import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  orders = [
    {
      Id: "1", Date: "11-16-2022", Sum: "15"
    },
    {
      Id: "1", Date: "11-16-2022", Sum: "15"
    },
    {
      Id: "1", Date: "11-16-2022", Sum: "15"
    },
    {
      Id: "1", Date: "11-16-2022", Sum: "15"
    },
    {
      Id: "1", Date: "11-16-2022", Sum: "15"
    },
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}

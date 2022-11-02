import {Component, OnInit} from '@angular/core';
import {Product} from "../../models/product";

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  products: Product[] = [
    {
      id: 1,
      name: "name",
      price: 200,
      description:"desc2",
      image: "https://newtea.ua/sites/default/files/styles/product-page-mobile/public/node/product/baj-hao-in-chzhen-sribni-golki-00.jpg",
      origin:{
        id: 2,
        name: "Індія"
      },
      type:{
        id: 2,
        name: "Чорний"
      },
      properties:[      {
        "id": 2,
        "name": "property2"
      },
        {
          "id": 3,
          "name": "property3"
        },
        {
          "id": 1,
          "name": "property1"
        }],
      flavors:[ {
        id: 1,
        name: "flavor1"
      },
        {
          id: 2,
          name:"flavor2"
        },
        {
          "id": 3,
          "name": "flavor3"
        }]
    },
    {
      id: 2,
      name: "name",
      price: 200,
      description:"desc2",
      image: "https://newtea.ua/sites/default/files/styles/product-page-mobile/public/node/product/baj-hao-in-chzhen-sribni-golki-00.jpg",
      origin:{
        id: 2,
        name: "Індія"
      },
      type:{
        id: 2,
        name: "Чорний"
      },
      properties:[      {
        "id": 2,
        "name": "property2"
      },
        {
          "id": 3,
          "name": "property3"
        },
        {
          "id": 1,
          "name": "property1"
        }],
      flavors:[ {
        id: 1,
        name: "flavor1"
      },
        {
          id: 2,
          name:"flavor2"
        },
        {
          "id": 3,
          "name": "flavor3"
        }]
    },
    {
      id: 3,
      name: "name",
      price: 200,
      description:"desc2",
      image: "https://newtea.ua/sites/default/files/styles/product-page-mobile/public/node/product/baj-hao-in-chzhen-sribni-golki-00.jpg",
      origin:{
        id: 2,
        name: "Індія"
      },
      type:{
        id: 2,
        name: "Чорний"
      },
      properties:[      {
        "id": 2,
        "name": "property2"
      },
        {
          "id": 3,
          "name": "property3"
        },
        {
          "id": 1,
          "name": "property1"
        }],
      flavors:[ {
        id: 1,
        name: "flavor1"
      },
        {
          id: 2,
          name:"flavor2"
        },
        {
          "id": 3,
          "name": "flavor3"
        }]
    },
    {
      id: 4,
      name: "name",
      price: 200,
      description:"desc2",
      image: "https://newtea.ua/sites/default/files/styles/product-page-mobile/public/node/product/baj-hao-in-chzhen-sribni-golki-00.jpg",
      origin:{
        id: 2,
        name: "Індія"
      },
      type:{
        id: 2,
        name: "Чорний"
      },
      properties:[      {
        "id": 2,
        "name": "property2"
      },
        {
          "id": 3,
          "name": "property3"
        },
        {
          "id": 1,
          "name": "property1"
        }],
      flavors:[ {
        id: 1,
        name: "flavor1"
      },
        {
          id: 2,
          name:"flavor2"
        },
        {
          "id": 3,
          "name": "flavor3"
        }]
    },
    {
      id: 5,
      name: "name",
      price: 200,
      description:"desc2",
      image: "https://newtea.ua/sites/default/files/styles/product-page-mobile/public/node/product/baj-hao-in-chzhen-sribni-golki-00.jpg",
      origin:{
        id: 2,
        name: "Індія"
      },
      type:{
        id: 2,
        name: "Чорний"
      },
      properties:[      {
        "id": 2,
        "name": "property2"
      },
        {
          "id": 3,
          "name": "property3"
        },
        {
          "id": 1,
          "name": "property1"
        }],
      flavors:[ {
        id: 1,
        name: "flavor1"
      },
        {
          id: 2,
          name:"flavor2"
        },
        {
          "id": 3,
          "name": "flavor3"
        }]
    }
  ];

  constructor() {
  }

  ngOnInit(): void {
  }

}

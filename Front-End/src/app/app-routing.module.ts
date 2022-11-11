import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ShopComponent} from "./shop/shop.component";
import {MainPageComponent} from "./main-page/main-page.component";
import {BlogComponent} from "./blog/blog.component";
import {CartComponent} from "./cart/cart.component";

const routes: Routes = [
  {path:'', component: MainPageComponent },
  {path:'shop', component: ShopComponent},
  {path:'blog', component:BlogComponent},
  {path:'cart', component:CartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

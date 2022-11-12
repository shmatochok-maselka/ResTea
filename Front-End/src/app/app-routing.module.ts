import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ShopComponent} from "./shop/shop.component";
import {MainPageComponent} from "./main-page/main-page.component";
import {BlogComponent} from "./blog/blog.component";
import {OneProductComponent} from "./one-product/one-product.component";

const routes: Routes = [
  {path:'', component: MainPageComponent },
  {path:'shop', component: ShopComponent},
  {path:'blog', component:BlogComponent},
  {path:'shop/:id', component: OneProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ShopComponent} from "./shop/shop.component";
import {MainPageComponent} from "./main-page/main-page.component";
import {BlogComponent} from "./blog/blog.component";
import {OneProductComponent} from "./one-product/one-product.component";
import {AboutUsPageComponent} from "./about-us-page/about-us-page.component";
import {ContactsPageComponent} from "./contacts-page/contacts-page.component";

const routes: Routes = [
  {path:'', component: MainPageComponent },
  {path:'shop', component: ShopComponent},
  {path:'blog', component:BlogComponent},
  {path:'shop/:id', component: OneProductComponent},
  {path:'about-us', component: AboutUsPageComponent},
  {path:'contacts',component:ContactsPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

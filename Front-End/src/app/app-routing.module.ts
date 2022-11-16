import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ShopComponent} from "./shop/shop.component";
import {MainPageComponent} from "./main-page/main-page.component";
import {BlogComponent} from "./blog/blog.component";
import {OneProductComponent} from "./one-product/one-product.component";
import {AboutUsPageComponent} from "./about-us-page/about-us-page.component";
import {ContactsPageComponent} from "./contacts-page/contacts-page.component";
import {LoginComponent} from "./login/login.component";
import {RegistrationComponent} from "./registration/registration.component";
import {CartComponent} from "./cart/cart.component";
import {AuthGuard} from "./auth/auth.guard";
import {BlogPostPageComponent} from "./blog/blog-post-page/blog-post-page.component";

const routes: Routes = [
  {path:'', component: MainPageComponent },
  {path:'shop', component: ShopComponent},
  {path:'blog', component:BlogComponent},
  {path:'blog/:id', component:BlogPostPageComponent},
  {path:'shop/:id', component: OneProductComponent},
  {path:'about-us', component: AboutUsPageComponent},
  {path:'contacts',component:ContactsPageComponent, },
  {path:'login', component:LoginComponent},
  {path:'register', component:RegistrationComponent},
  {path:'cart', component:CartComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

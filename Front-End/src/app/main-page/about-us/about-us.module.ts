import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AboutUsComponent} from './about-us.component';
import {FlexModule, FlexLayoutModule} from "@angular/flex-layout";
import {MatButtonModule} from "@angular/material/button";
import {RouterLinkWithHref} from "@angular/router";


@NgModule({
  declarations: [
    AboutUsComponent
  ],
    imports: [
        CommonModule,
        FlexModule,
        MatButtonModule,
        RouterLinkWithHref,
    ],
  exports: [
    AboutUsComponent
  ]
})
export class AboutUsModule {
}

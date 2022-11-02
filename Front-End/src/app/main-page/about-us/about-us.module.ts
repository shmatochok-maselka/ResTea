import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AboutUsComponent} from './about-us.component';
import {FlexModule, FlexLayoutModule} from "@angular/flex-layout";


@NgModule({
  declarations: [
    AboutUsComponent
  ],
  imports: [
    CommonModule,
    FlexModule,
  ],
  exports: [
    AboutUsComponent
  ]
})
export class AboutUsModule {
}

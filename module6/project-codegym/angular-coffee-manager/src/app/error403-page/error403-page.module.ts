import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Error403PageRoutingModule } from './error403-page-routing.module';
import { Error403PageComponent } from './error403-page.component';


@NgModule({
  declarations: [Error403PageComponent],
  imports: [
    CommonModule,
    Error403PageRoutingModule
  ]
})
export class Error403PageModule { }

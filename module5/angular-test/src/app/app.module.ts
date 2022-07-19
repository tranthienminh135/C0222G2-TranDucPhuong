import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerListComponent } from './furama-management/customer-management/customer-list/customer-list.component';
import { CustomerCreateComponent } from './furama-management/customer-management/customer-create/customer-create.component';
import {CustomerRoutingModule} from './furama-management/customer-management/customer-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    CustomerCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CustomerRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

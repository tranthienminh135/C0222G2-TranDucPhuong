import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerListComponent } from './furama-management/customer-management/customer-list/customer-list.component';
import { CustomerCreateComponent } from './furama-management/customer-management/customer-create/customer-create.component';
import {CustomerRoutingModule} from './furama-management/customer-management/customer-routing.module';
import { ModalCreateCustomerComponent } from './furama-management/customer-management/modal-create-customer/modal-create-customer.component';
import { ModalMessageComponent } from './furama-management/customer-management/modal-message/modal-message.component';
import {HttpClientModule} from '@angular/common/http';
import { AppUserComponent } from './app-user/app-user.component';
import { ModalEditCustomerComponent } from './furama-management/customer-management/modal-edit-customer/modal-edit-customer.component';
import {ReactiveFormsModule} from '@angular/forms';
import { EmployeeManagementComponent } from './employee-management/employee-management.component';
import { CustomerManagementComponent } from './customer-management/customer-management.component';
import { ModalDeleteComponent } from './customer-management/modal-delete/modal-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    CustomerCreateComponent,
    ModalCreateCustomerComponent,
    ModalMessageComponent,
    AppUserComponent,
    ModalEditCustomerComponent,
    EmployeeManagementComponent,
    CustomerManagementComponent,
    ModalDeleteComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        CustomerRoutingModule,
        HttpClientModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

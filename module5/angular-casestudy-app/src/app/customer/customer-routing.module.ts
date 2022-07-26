import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';

const routes: Routes = [
  {
    path: 'customer-list',
    component: ListCustomerComponent
  },
  {
    path: 'customer-edit',
    component: EditCustomerComponent
  },
  {
    path: 'customer-edit/:id',
    component: EditCustomerComponent
  },
  {
    path: 'customer-list/:id',
    component: ListCustomerComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class CustomerRoutingModule { }

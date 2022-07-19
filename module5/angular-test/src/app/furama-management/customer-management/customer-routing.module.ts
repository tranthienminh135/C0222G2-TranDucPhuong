import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerCreateComponent} from './customer-create/customer-create.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'customer-list'
  },
  {
    path: 'customer-list',
    component: CustomerListComponent
  },
  {
    path: 'customer-create',
    component: CustomerCreateComponent
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

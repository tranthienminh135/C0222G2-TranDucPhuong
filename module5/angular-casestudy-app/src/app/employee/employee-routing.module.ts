import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ListEmployeeComponent} from './list-employee/list-employee.component';

const routes: Routes = [
  {
    path: 'employee-list',
    component: ListEmployeeComponent
  }
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class EmployeeRoutingModule { }

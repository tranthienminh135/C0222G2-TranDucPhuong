import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ListEmployeeComponent} from './list-employee/list-employee.component';
import {EditEmployeeComponent} from './edit-employee/edit-employee.component';

const routes: Routes = [
  {
    path: 'employee-list',
    component: ListEmployeeComponent
  },
  {
    path: 'employee-edit/:idEdit',
    component: EditEmployeeComponent
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

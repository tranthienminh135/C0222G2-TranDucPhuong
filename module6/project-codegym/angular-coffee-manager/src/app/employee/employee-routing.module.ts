import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EmployeeComponent} from "./employee.component";
import {CommonModule} from "@angular/common";
import {AdminGuard} from "../guard/admin.guard";

const routes: Routes = [
  {
    path: 'employee',
    component: EmployeeComponent,
    canActivate: [AdminGuard]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    CommonModule
  ]
})
export class EmployeeRoutingModule { }

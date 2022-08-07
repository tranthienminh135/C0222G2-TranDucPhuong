import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomePageRoutingModule} from "./home-page/home-page-routing.module";
import {EmployeeRoutingModule} from "./employee/employee-routing.module";
import {LoginRoutingModule} from "./login/login-routing.module";

const routes: Routes = [
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    HomePageRoutingModule,
    EmployeeRoutingModule,
    LoginRoutingModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

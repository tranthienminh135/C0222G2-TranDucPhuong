import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomePageRoutingModule} from "./home-page/home-page-routing.module";
import {EmployeeRoutingModule} from "./employee/employee-routing.module";
import {LoginRoutingModule} from "./login/login-routing.module";
import {Error403PageRoutingModule} from "./error403-page/error403-page-routing.module";
import {ForgotPasswordRoutingModule} from "./forgot-password/forgot-password-routing.module";

const routes: Routes = [
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    HomePageRoutingModule,
    EmployeeRoutingModule,
    LoginRoutingModule,
    Error403PageRoutingModule,
    ForgotPasswordRoutingModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

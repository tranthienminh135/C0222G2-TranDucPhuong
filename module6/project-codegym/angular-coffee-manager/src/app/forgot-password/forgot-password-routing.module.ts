import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ForgotPasswordComponent} from "./forgot-password.component";


const routes: Routes = [
  {
    path: 'forgot',
    component: ForgotPasswordComponent
  }
  ,{
    path: 'forgot/:token',
    component: ForgotPasswordComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ForgotPasswordRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ResisterFormComponent} from './resister-form/resister-form.component';
import {LoginFormComponent} from './login-form/login-form.component';


const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'login'
  },
  {
    path: 'login',
    component: LoginFormComponent
  },
  {
    path: 'register',
    component: ResisterFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login.component';
import {IsLoginGuard} from "../guard/is-login.guard";

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [IsLoginGuard]
  }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(routes),
    CommonModule
  ]
})
export class LoginRoutingModule { }

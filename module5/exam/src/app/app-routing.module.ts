import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ConsignmentComponent} from './consignment/consignment.component';
import {CreateComponent} from './consignment/create/create.component';
import {EditComponent} from './consignment/edit/edit.component';
import {LoginComponent} from './login/login.component';
import {AuthUserGuard} from './service/auth-user.guard';
import {AuthAdminGuard} from './service/auth-admin.guard';

const routes: Routes = [
  {
    path: "",
    pathMatch: "full",
    redirectTo: "list"
  },
  {
    path: 'list',
    component: ConsignmentComponent,
    canActivate: [AuthUserGuard]
  },
  {
    path: 'create',
    component: CreateComponent,
    canActivate: [AuthAdminGuard]
  },
  {
    path: "edit/:id",
    component: EditComponent,
    canActivate: [AuthAdminGuard]
  },
  {
    path: "login",
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ProductListComponent} from './product/product-list/product-list.component';
import {ProductCreateComponent} from './product/product-create/product-create.component';
import {ProductEditComponent} from "./product/product-edit/product-edit.component";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./service/auth.guard";

const routes: Routes = [
  {
    path: 'product/list',
    component: ProductListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'product/create',
    component: ProductCreateComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'product/edit/:idEdit',
    component: ProductEditComponent
  },
  {
    path: 'product/delete/:idDelete',
    component: ProductListComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

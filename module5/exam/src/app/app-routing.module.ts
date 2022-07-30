import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ConsignmentComponent} from './consignment/consignment.component';
import {CreateComponent} from './consignment/create/create.component';

const routes: Routes = [
  {
    path: "",
    pathMatch: "full",
    redirectTo: "list"
  },
  {
    path: 'list',
    component: ConsignmentComponent
  },
  {
    path: 'create',
    component: CreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

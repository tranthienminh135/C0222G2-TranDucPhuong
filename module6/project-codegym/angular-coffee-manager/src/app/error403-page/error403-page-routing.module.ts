import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {Error403PageComponent} from "./error403-page.component";


const routes: Routes = [
  {
    path: 'error403',
    component: Error403PageComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class Error403PageRoutingModule { }

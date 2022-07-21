import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ListContractComponent} from './list-contract/list-contract.component';

const routes: Routes = [
  {
    path: 'contract-list',
    component: ListContractComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class ContractRoutingModule { }

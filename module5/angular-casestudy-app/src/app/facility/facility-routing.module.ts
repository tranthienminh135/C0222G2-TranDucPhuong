import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ListFacilityComponent} from './list-facility/list-facility.component';
import {EditFacilityComponent} from './edit-facility/edit-facility.component';

const routes: Routes = [
  {
    path: 'facility-list',
    component: ListFacilityComponent
  },
  {
    path: 'facility-edit',
    component: EditFacilityComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class FacilityRoutingModule { }

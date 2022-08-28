import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductManagementRoutingModule } from './product-management-routing.module';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductCreateComponent } from './product-create/product-create.component';
import {ReactiveFormsModule} from "@angular/forms";
import {NgxPaginationModule} from "ngx-pagination";


@NgModule({
  declarations: [ProductListComponent, ProductCreateComponent],
  imports: [
    CommonModule,
    ProductManagementRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ]
})
export class ProductManagementModule { }

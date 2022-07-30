import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from 'ngx-toastr';
import {NgxPaginationModule} from 'ngx-pagination';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import { ConsignmentComponent } from './consignment/consignment.component';
import { EditComponent } from './consignment/edit/edit.component';
import { CreateComponent } from './consignment/create/create.component';

@NgModule({
  declarations: [
    AppComponent,
    ConsignmentComponent,
    EditComponent,
    CreateComponent
  ],
  imports: [
    [BrowserModule, NgxPaginationModule],
    AppRoutingModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(),
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

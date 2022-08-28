import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ToastrModule} from "ngx-toastr";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AngularFireStorageModule} from "@angular/fire/storage";
import {AngularFireModule} from "@angular/fire";
import {environment} from "../environments/environment";
import {LoadingRoutingModule} from "./loading/loading-routing.module";
import {NgxPaginationModule} from "ngx-pagination";
import {HeaderRoutingModule} from "./header/header-routing.module";
import {HeaderModule} from "./header/header.module";
import {FooterModule} from "./footer/footer.module";
import {HomePageRoutingModule} from "./home-page/home-page-routing.module";
import {HomePageModule} from "./home-page/home-page.module";
import {ProductManagementModule} from "./product-management/product-management.module";
import {ProductManagementRoutingModule} from "./product-management/product-management-routing.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    [BrowserModule, NgxPaginationModule],
    AppRoutingModule,
    LoadingRoutingModule,
    HeaderRoutingModule,
    HomePageRoutingModule,
    BrowserAnimationsModule,
    ProductManagementRoutingModule,
    ToastrModule.forRoot(
      {
        timeOut: 2000,
        closeButton: true,
        progressBar: true,
        positionClass: 'toast-top-right',
        preventDuplicates: true
      }
    ),
    ReactiveFormsModule,
    HttpClientModule,
    AngularFireStorageModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    HeaderModule,
    FooterModule,
    HomePageModule,
    ProductManagementModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from 'ngx-toastr';
import {AngularFireStorageModule} from '@angular/fire/storage';
import {AngularFireModule} from '@angular/fire';
import {environment} from '../environments/environment';
import {EmployeeModule} from "./employee/employee.module";
import {HomePageModule} from "./home-page/home-page.module";
import {LoginModule} from "./login/login.module";
import {Error403PageModule} from "./error403-page/error403-page.module";
import {ForgotPasswordModule} from "./forgot-password/forgot-password.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(
      {
        timeOut: 2000,
        closeButton: true,
        progressBar: true,
        positionClass: 'toast-top-right',
        preventDuplicates: true,
      }
    ),
    HttpClientModule,
    ReactiveFormsModule,
    AngularFireStorageModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    EmployeeModule,
    HomePageModule,
    LoginModule,
    Error403PageModule,
    ForgotPasswordModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

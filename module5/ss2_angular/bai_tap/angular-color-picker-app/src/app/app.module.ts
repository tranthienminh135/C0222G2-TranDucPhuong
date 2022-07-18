import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AngularColorPickerAppComponent } from './angular-color-picker-app/angular-color-picker-app.component';

@NgModule({
  declarations: [
    AppComponent,
    AngularColorPickerAppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

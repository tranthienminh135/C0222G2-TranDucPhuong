import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AbcComponent } from './abc/abc.component';
import { BcdComponent } from './bcd/bcd.component';

@NgModule({
  declarations: [
    AppComponent,
    AbcComponent,
    BcdComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

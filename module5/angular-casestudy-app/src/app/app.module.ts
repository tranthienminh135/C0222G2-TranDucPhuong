import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './common/footer/footer.component';
import { HomePageComponent } from './home-page/home-page.component';
import { NavigationComponent } from './common/navigation/navigation.component';
import { ListFacilityComponent } from './facility/list-facility/list-facility.component';
import {HomePageRoutingModule} from './home-page/home-page-routing.module';
import {FacilityRoutingModule} from './facility/facility-routing.module';
import { EditFacilityComponent } from './facility/edit-facility/edit-facility.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HomePageComponent,
    NavigationComponent,
    ListFacilityComponent,
    EditFacilityComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomePageRoutingModule,
    FacilityRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

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
import { RoomInputEditComponent } from './facility/edit-facility/room-input-edit/room-input-edit.component';
import { HouseInputEditComponent } from './facility/edit-facility/house-input-edit/house-input-edit.component';
import { VillaInputEditComponent } from './facility/edit-facility/villa-input-edit/villa-input-edit.component';
import { CustomerComponent } from './customer/customer.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HomePageComponent,
    NavigationComponent,
    ListFacilityComponent,
    EditFacilityComponent,
    RoomInputEditComponent,
    HouseInputEditComponent,
    VillaInputEditComponent,
    CustomerComponent
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

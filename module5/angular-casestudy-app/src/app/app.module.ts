import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FooterComponent} from './common/footer/footer.component';
import {HomePageComponent} from './home-page/home-page.component';
import {NavigationComponent} from './common/navigation/navigation.component';
import {ListFacilityComponent} from './facility/list-facility/list-facility.component';
import {HomePageRoutingModule} from './home-page/home-page-routing.module';
import {FacilityRoutingModule} from './facility/facility-routing.module';
import {EditFacilityComponent} from './facility/edit-facility/edit-facility.component';
import {RoomInputEditComponent} from './facility/edit-facility/room-input-edit/room-input-edit.component';
import {HouseInputEditComponent} from './facility/edit-facility/house-input-edit/house-input-edit.component';
import {VillaInputEditComponent} from './facility/edit-facility/villa-input-edit/villa-input-edit.component';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {CustomerRoutingModule} from './customer/customer-routing.module';
import {EditCustomerComponent} from './customer/edit-customer/edit-customer.component';
import {ListContractComponent} from './contract/list-contract/list-contract.component';
import {ContractRoutingModule} from './contract/contract-routing.module';
import {ListEmployeeComponent} from './employee/list-employee/list-employee.component';
import {EmployeeRoutingModule} from './employee/employee-routing.module';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from 'ngx-toastr';

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
    ListCustomerComponent,
    EditCustomerComponent,
    ListContractComponent,
    ListEmployeeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomePageRoutingModule,
    FacilityRoutingModule,
    CustomerRoutingModule,
    ContractRoutingModule,
    EmployeeRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

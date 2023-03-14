import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './layout/footer/footer.component';
import { HeaderComponent } from './layout/header/header.component';
import { CommonComponent } from './layout/common/common.component';
import { CustomerListComponent } from './furama/customer-furama/customer-list/customer-list.component';
import { CustomerDetailComponent } from './furama/customer-furama/customer-detail/customer-detail.component';
import { CustomerCreateComponent } from './furama/customer-furama/customer-create/customer-create.component';
import { CustomerUpdateComponent } from './furama/customer-furama/customer-update/customer-update.component';
import {RouterModule} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ServiceCreateComponent } from './furama/service-furama/service-create/service-create.component';
import { ServiceDetailComponent } from './furama/service-furama/service-detail/service-detail.component';
import { ServiceListComponent } from './furama/service-furama/service-list/service-list.component';
import { ServiceUpdateComponent } from './furama/service-furama/service-update/service-update.component';
import { ContractListComponent } from './furama/contract/contract-list/contract-list.component';
import { ContractCreateComponent } from './furama/contract/contract-create/contract-create.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    CommonComponent,
    CustomerListComponent,
    CustomerDetailComponent,
    CustomerCreateComponent,
    CustomerUpdateComponent,
    ServiceCreateComponent,
    ServiceDetailComponent,
    ServiceListComponent,
    ServiceUpdateComponent,
    ContractListComponent,
    ContractCreateComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    RouterModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

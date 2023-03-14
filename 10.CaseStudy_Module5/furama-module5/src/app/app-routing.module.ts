import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerListComponent} from "./furama/customer-furama/customer-list/customer-list.component";
import {CustomerCreateComponent} from "./furama/customer-furama/customer-create/customer-create.component";
import {CustomerUpdateComponent} from "./furama/customer-furama/customer-update/customer-update.component";
import {CustomerDetailComponent} from "./furama/customer-furama/customer-detail/customer-detail.component";
import {ServiceListComponent} from "./furama/service-furama/service-list/service-list.component";
import {ServiceCreateComponent} from "./furama/service-furama/service-create/service-create.component";
import {ServiceUpdateComponent} from "./furama/service-furama/service-update/service-update.component";
import {ServiceDetailComponent} from "./furama/service-furama/service-detail/service-detail.component";
import {ContractListComponent} from "./furama/contract/contract-list/contract-list.component";
import {ContractCreateComponent} from "./furama/contract/contract-create/contract-create.component";


const routes: Routes = [
  {path: "customer", component: CustomerListComponent},
  {path: "customer/create", component: CustomerCreateComponent},
  {path: "customer/update/:id", component: CustomerUpdateComponent},
  {path: "customer/detail/:id", component: CustomerDetailComponent},
  {path: "service", component: ServiceListComponent},
  {path: "service/create", component: ServiceCreateComponent},
  {path: "service/update/:id", component: ServiceUpdateComponent},
  {path: "service/detail/:id", component: ServiceDetailComponent},
  {path: "contract", component: ContractListComponent},
  {path: "contract/create", component: ContractCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../../../model/customer/customerType";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../../service/customer.service";
import {Subscription} from "rxjs";
import {Customer} from "../../../model/customer/customer";

@Component({
  selector: 'app-customer-update',
  templateUrl: './customer-update.component.html',
  styleUrls: ['./customer-update.component.css']
})
export class CustomerUpdateComponent implements OnInit {

  rfCustomer: FormGroup;
  customerTypes: CustomerType[] | undefined;
  customer: Customer | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private customerService: CustomerService,
    private  activatedRoute: ActivatedRoute
  ) {
  }

  //DI
  private subscription: Subscription | undefined;

  ngOnInit(): void {
    //Lấy khách hàng theo id
    const customerId = parseInt(this.activatedRoute.snapshot.params['id']);
    this.subscription = this.customerService.getAllCustomerType().subscribe(
      data => { // then
        this.customerTypes = data;
        this.customerService.getCustomerById(customerId).subscribe(
          data => {
            this.customer = data;
            console.log(this.customer);
            console.log(this.customerTypes);
            this.rfCustomer = this.formBuilder.group({
              id: [this.customer.id],
              name: [this.customer.name, [Validators.required, Validators.minLength(5)]],
              dayOfBirth: [this.customer.dayOfBirth],
              gender: [this.customer.gender],
              idCard: [this.customer.idCard],
              phone: [this.customer.phone],
              email: [this.customer.email],
              customerType: [this.customer.customerType],
              address: [this.customer.address]
            })
          }, error => { // catch
            console.log("Lay khach hang that bai")
          },
        );
      })
  }

  onSubmit(id: number) {
    if (this.rfCustomer.valid) {
      this.customerService.editCustomer(id, this.rfCustomer.value).subscribe(
        data => {
          console.log(data);
          this.router.navigateByUrl("/customer");
        }, error => { // catch
          console.log("cap nhat that bai")
        },
        // () => { // finally
        //
        // }
      );
    }

  }
}

import {Component, OnInit} from '@angular/core';
import {Customer} from "../../../model/customer/customer";
import {CustomerService} from "../../../service/customer.service";
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  customer: Customer | undefined;

  constructor(
    private customerService: CustomerService,
    private  activatedRoute: ActivatedRoute
  ) {
  }

  //DI
  private subscription: Subscription | undefined;

  ngOnInit(): void {

    //Lấy khách hàng theo id
    const customerId = parseInt(this.activatedRoute.snapshot.params['id']);
    this.subscription = this.customerService.getCustomerById(customerId).subscribe(
      data => {
        this.customer = data;
      }, error => { // catch
        console.log("Lay khach hang that bai")
      },
    );
  }

}

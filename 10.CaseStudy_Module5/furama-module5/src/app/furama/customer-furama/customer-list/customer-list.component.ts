import {Component, OnInit} from '@angular/core';
import {Customer} from "../../../model/customer/customer";
import {Subscription} from "rxjs";
import {CustomerService} from "../../../service/customer.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  contentSearch: Customer = {name: ""};

  customer: Customer | undefined;

  customers: Customer[] | undefined;

  customersFilter: Customer[] | undefined;

  nameCustomer: string | undefined;

  idDelete: number;

  message: string;

  constructor(private customerService: CustomerService,
              private router: Router,
              private  activatedRoute: ActivatedRoute
  ) {

  }

  //DI
  private subscription: Subscription | undefined;

  ngOnInit(): void {
    this.getAllCustomer();

  }

  showDetail(s: any) {
  }

  getAllCustomer() {
    this.subscription = this.customerService.getAllCustomer().subscribe(
      data => { // then
        this.customers = data;

        this.subscription = this.activatedRoute.queryParams.subscribe((params: Params) => {
          this.message = params['message'];
        });

      }, error => { // catch
        console.log("Lay danh sach sinh vien that bai")
      },
    );
  }

  sendId(id: number, name: string) {
    this.idDelete = id;
    this.nameCustomer = name;
  }

  delete(id: any) {
    console.log(id);
    this.customerService.deleteCustomerById(id).subscribe(
      data => {
        this.getAllCustomer()
      }, error => { // catch
        console.log("Xoa khach hang that bai")
      },
      // () => { // finally
      //
      // }
    );
  }

  //Search cach 1:

  search(searchForm: NgForm) {
    console.log("noi dung search " + this.contentSearch.name);
    this.customerService.getAllCustomerByName(this.contentSearch.name).subscribe(
      data => {
        this.customers = data;
      }, error => { // catch
        console.log("Xoa khach hang that bai")
      },
    );
  }

//  Search cach 2:
  /*
  search(nameSearch: string) {
    this.getAllCustomer();

    this.customersFilter = this.customers.filter((cus: Customer) => cus.phone == nameSearch );
    this.customers = this.customersFilter;

    this.customers = null;

    console.log(this.customers);
  }

   */
}

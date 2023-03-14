import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {CustomerService} from "../../../service/customer.service";
import {CustomerType} from "../../../model/customer/customerType";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  rfCustomer: FormGroup;
  customerTypes: CustomerType[] | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private customerService: CustomerService
  ) {
  }

  //DI
  private subscription: Subscription | undefined;

  ngOnInit(): void {

    //Lấy customer type để hiện thị chỗ select
    this.subscription = this.customerService.getAllCustomerType().subscribe(
      data => { // then
        this.customerTypes = data;
      }, error => { // catch
        console.log("Lay danh sach khach hang that bai")
      },
    );

    this.rfCustomer = this.formBuilder.group({
      // id:[],
      name: ['', [Validators.required, Validators.minLength(5)]],
      dayOfBirth: [''],
      gender: [1],
      idCard: [''],
      phone: [''],
      email: [''],
      customerType: [''],
      address: ['']
    })
  }

  onSubmit() {
    console.log(this.rfCustomer.value);
    if (this.rfCustomer.valid) {
      this.customerService.save(this.rfCustomer.value).subscribe(
        data => {
          console.log(data);
          // this.router.navigateByUrl("/customer");
          // this.router.navigate(['/customer', { message: 'đasdasd'}]);
          this.router.navigate(['/customer'],
            {queryParams: {message: "Tạo mới khach hang " + this.rfCustomer.value.name + " thành công"}});

          alert("Đã tạo mới thành công");
        }, error => { // catch
          console.log("tao moi sinh vien that bai")
        },
        // () => { // finally
        //
        // }
      );
    }
  }
}

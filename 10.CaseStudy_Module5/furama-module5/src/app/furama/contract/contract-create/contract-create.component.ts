import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Customer} from "../../../model/customer/customer";
import {Service} from "../../../model/service/service";
import {Router} from "@angular/router";
import {CustomerService} from "../../../service/customer.service";
import {ServiceService} from "../../../service/service.service";
import {ContractService} from "../../../service/contract.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {

  rfContract: FormGroup;
  customers: Customer[] | undefined;
  services: Service[] | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private customerService: CustomerService,
    private serviceService: ServiceService,
    private contractService: ContractService
  ) {
  }

  private subscription: Subscription | undefined;

  ngOnInit(): void {
    this.subscription = this.customerService.getAllCustomer().subscribe(
      data => { // then
        this.customers = data;
        this.serviceService.getAllService().subscribe(
          data => {
            this.services = data;
          })
      })

    this.rfContract = this.formBuilder.group({
      codeContract: ['', [Validators.required, Validators.minLength(5)]],
      customer: [''],
      service: [''],
      dateStart: [''],
      dateEnd: [''],
      deposits: ['']

    })
  }


  onSubmit() {
    if (this.rfContract.valid) {
      this.contractService.save(this.rfContract.value).subscribe(
        data => {
          console.log(data);
          // this.router.navigateByUrl("/customer");
          // this.router.navigate(['/customer', { message: 'đasdasd'}]);
          this.router.navigate(['/contract'],
            {queryParams: {message: "Tạo mới hợp đồng " + this.rfContract.value.codeContract + " thành công"}});

          alert("Đã tạo mới thành công");
        }, error => { // catch
          console.log("tao moi hợp đồng that bai")
        },
        // () => { // finally
        //
        // }
      );
    }
  }
}

import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AccompaniedService} from "../../../model/service/accompaniedService";
import {RentType} from "../../../model/service/rentType";
import {ServiceType} from "../../../model/service/serviceType";
import {Router} from "@angular/router";
import {ServiceService} from "../../../service/service.service";
import {Subscription} from "rxjs";
import {Service} from "../../../model/service/service";

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {

  rfService: FormGroup;
  accompaniedServices: AccompaniedService[] | undefined;
  rentTypes: RentType[] | undefined;
  serviceTypes: ServiceType[] | undefined;
  service: Service ={id: 1, name: 'villa'};

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private serviceService: ServiceService
  ) {
  }

  //DI
  private subscription: Subscription | undefined;

  ngOnInit(): void {

    this.subscription = this.serviceService.getAllAccompaniedService().subscribe(
      data => { // then
        this.accompaniedServices = data;
        this.serviceService.getAllRentType().subscribe(
          data => {
            this.rentTypes = data;

            this.serviceService.getAllServiceType().subscribe(
              data => {
                this.serviceTypes = data;
              })
          })
      })

    this.rfService = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(5)]],
      serviceArea: [''],
      serviceCost: [''],
      serviceMaxPeople: [''],
      standardRoom: [''],
      descriptionOtherConvenience: [''],
      poolArea: [''],
      numberOfFloors: [''],
      rentType: [''],
      accompaniedService: [''],
      // serviceType: [this.service.serviceType],
      serviceType: [''],

    })
  }

  onSubmit() {
    if (this.rfService.valid) {
      this.serviceService.save(this.rfService.value).subscribe(
        data => {
          console.log(data);
          // this.router.navigateByUrl("/customer");
          // this.router.navigate(['/customer', { message: 'đasdasd'}]);
          this.router.navigate(['/service'],
            {queryParams: {message: "Tạo mới dịch vụ " + this.rfService.value.name + " thành công"}});

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

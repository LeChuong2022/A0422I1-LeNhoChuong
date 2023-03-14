import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AccompaniedService} from "../../../model/service/accompaniedService";
import {RentType} from "../../../model/service/rentType";
import {ServiceType} from "../../../model/service/serviceType";
import {ActivatedRoute, Router} from "@angular/router";
import {ServiceService} from "../../../service/service.service";
import {Subscription} from "rxjs";
import {Service} from "../../../model/service/service";

@Component({
  selector: 'app-service-update',
  templateUrl: './service-update.component.html',
  styleUrls: ['./service-update.component.css']
})
export class ServiceUpdateComponent implements OnInit {

  rfService: FormGroup;
  accompaniedServices: AccompaniedService[] | undefined;
  rentTypes: RentType[] | undefined;
  serviceTypes: ServiceType[] | undefined;
  service: Service | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private  activatedRoute: ActivatedRoute,
    private serviceService: ServiceService
  ) {
  }

  //DI
  private subscription: Subscription | undefined;

  ngOnInit()
    :
    void {
    //Lấy khách hàng theo id
    const serviceId = parseInt(this.activatedRoute.snapshot.params['id']);
    this.subscription = this.serviceService.getAllAccompaniedService().subscribe(
      data => { // then
        this.accompaniedServices = data;
        this.serviceService.getAllRentType().subscribe(
          data => {
            this.rentTypes = data;

            this.serviceService.getAllServiceType().subscribe(
              data => {
                this.serviceTypes = data;
                this.serviceService.getServiceById(serviceId).subscribe(
                  data => {
                    this.service = data;
                    this.rfService = this.formBuilder.group({
                      id: [this.service.id],
                      name: [this.service.name, [Validators.required, Validators.minLength(5)]],
                      serviceArea: [this.service.serviceArea],
                      serviceCost: [this.service.serviceCost],
                      serviceMaxPeople: [this.service.serviceMaxPeople],
                      standardRoom: [this.service.standardRoom],
                      descriptionOtherConvenience: [this.service.descriptionOtherConvenience],
                      poolArea: [this.service.poolArea],
                      numberOfFloors: [this.service.numberOfFloors],
                      rentType: [this.service.rentType],
                      accompaniedService: [this.service.accompaniedService],
                      serviceType: [this.service.serviceType]
                    })
                  }, error => { // catch
                    console.log("Lay khach hang that bai")
                  },
                );
              })

          })
      }
    )


  }

  onSubmit(id: number) {
    if (this.rfService.valid) {
      this.serviceService.editService(id, this.rfService.value).subscribe(
        data => {
          console.log(data);
          this.router.navigateByUrl("/service");
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

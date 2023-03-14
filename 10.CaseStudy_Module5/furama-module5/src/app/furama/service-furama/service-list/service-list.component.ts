import { Component, OnInit } from '@angular/core';
import {Service} from "../../../model/service/service";
import {CustomerService} from "../../../service/customer.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {ServiceService} from "../../../service/service.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {

  service: Service | undefined;
  services: Service[] | undefined;

  idDelete: number;
  nameDelete: string;
  message: string;

  constructor(private serviceService: ServiceService,
              private router: Router,
              private  activatedRoute: ActivatedRoute) { }

  private subscription: Subscription | undefined;

  ngOnInit(): void {
    this.getAllService();

  }
  getAllService() {
    this.subscription = this.serviceService.getAllService().subscribe(
      data => { // then
        this.services = data;

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
    this.nameDelete = name;
  }

  delete(id: any) {
    console.log(id);
    this.serviceService.deleteServiceById(id).subscribe(
      data => {
        this.getAllService()
      }, error => { // catch
        console.log("Xoa dich vu that bai")
      },
      // () => { // finally
      //
      // }
    );
  }
}

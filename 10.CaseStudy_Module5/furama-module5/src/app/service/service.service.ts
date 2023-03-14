import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer/customer";
import {CustomerType} from "../model/customer/customerType";
import {Service} from "../model/service/service";
import {ServiceType} from "../model/service/serviceType";
import {AccompaniedService} from "../model/service/accompaniedService";
import {RentType} from "../model/service/rentType";

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private API_URL_SERVICE = "http://localhost:3000/services";
  private API_URL_ACCOMPANIED_SERVICE = "http://localhost:3000/accompaniedServiceS";
  private API_URL_RENT_TYPE = "http://localhost:3000/rentTypes";
  private API_URL_SERVICE_TYPE = "http://localhost:3000/serviceTypes";

  constructor(private httpClient: HttpClient) {
  }

  getAllService(): Observable<Service[]> {
    return this.httpClient.get<Service[]>(this.API_URL_SERVICE);
  }

  getAllAccompaniedService(): Observable<AccompaniedService[]> {
    return this.httpClient.get<AccompaniedService[]>(this.API_URL_ACCOMPANIED_SERVICE);
  }

  getAllRentType(): Observable<RentType[]> {
    return this.httpClient.get<RentType[]>(this.API_URL_RENT_TYPE);
  }

  getAllServiceType(): Observable<ServiceType[]> {
    return this.httpClient.get<ServiceType[]>(this.API_URL_SERVICE_TYPE);
  }


  save(service: Service): Observable<Service> {
    return this.httpClient.post<Service>(this.API_URL_SERVICE, service);
  }

  getServiceById(id: number): Observable<Service> {
    return this.httpClient.get<Service>(this.API_URL_SERVICE + "/" + id);
  }

  deleteServiceById(id: number): Observable<any> {
    return this.httpClient.delete<Customer>(this.API_URL_SERVICE + "/" + id);
  }

  editService(id: number, service: Service): Observable<Service> {
    return this.httpClient.put<Customer>(this.API_URL_SERVICE + "/" + id, service);
  }
}

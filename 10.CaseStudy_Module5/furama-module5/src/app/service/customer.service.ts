import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Customer} from "../model/customer/customer";
import {Observable} from "rxjs";
import {CustomerType} from "../model/customer/customerType";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private API_URL_CUSTOMER = "http://localhost:3000/customers";
  private API_URL_CUSTOMER_TYPE = "http://localhost:3000/customerTypes";

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL_CUSTOMER);
  }

  getAllCustomerType(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(this.API_URL_CUSTOMER_TYPE);
  }


  save(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(this.API_URL_CUSTOMER, customer);
  }

  getCustomerById(id: number): Observable<Customer> {
    console.log("den day roi: " + id)
    return this.httpClient.get<Customer>(this.API_URL_CUSTOMER + "/" + id);
  }

  deleteCustomerById(id: number): Observable<any> {
    return this.httpClient.delete<Customer>(this.API_URL_CUSTOMER + "/" + id);
  }

  getStudentByIndex(index: number) {
    // customers: Customer[] = this.getAll();
    // return this._students[index];
  }

  editCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.httpClient.put<Customer>('http://localhost:3000/customers/' + id, customer);
  }

  getAllCustomerByName(name: string): Observable<Customer[]> {
    console.log("vi tri search " + name);
    return this.httpClient.get<Customer[]>(this.API_URL_CUSTOMER + "?name_like=" + name);
  }

}

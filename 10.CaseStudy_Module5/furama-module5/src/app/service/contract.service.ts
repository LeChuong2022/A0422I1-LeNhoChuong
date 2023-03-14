import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer/customer";
import {CustomerType} from "../model/customer/customerType";
import {Contract} from "../model/contract/contract";

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  private API_URL_CONTRACT = "http://localhost:3000/contracts";


  constructor(private httpClient: HttpClient) {
  }

  getAllContract(): Observable<Contract[]> {
    return this.httpClient.get<Contract[]>(this.API_URL_CONTRACT);
  }

  save(contract: Contract): Observable<Contract> {
    return this.httpClient.post<Contract>(this.API_URL_CONTRACT, contract);
  }

  getContractById(id: number): Observable<Contract> {
    console.log("den day roi: " + id)
    return this.httpClient.get<Contract>(this.API_URL_CONTRACT + "/" + id);
  }

  deleteContractById(id: number): Observable<any> {
    return this.httpClient.delete<Contract>(this.API_URL_CONTRACT + "/" + id);
  }

  editContract(id: number, contract: Contract): Observable<Contract> {
    return this.httpClient.put<Contract>(this.API_URL_CONTRACT + "/" + id, contract);
  }

}

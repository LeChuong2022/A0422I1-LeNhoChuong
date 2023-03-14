import {Component, OnInit} from '@angular/core';
import {Contract} from "../../../model/contract/contract";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {ContractService} from "../../../service/contract.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {

  contract: Contract | undefined;
  contracts: Contract[] | undefined;
  message: string;

  nameDelete: string | undefined;

  idDelete: number;

  constructor(
    private router: Router,
    private  activatedRoute: ActivatedRoute,
    private contractService: ContractService
  ) {
  }

  //DI
  private subscription: Subscription | undefined;

  ngOnInit(): void {
    this.getAllContract();
  }

  getAllContract() {
    this.subscription = this.contractService.getAllContract().subscribe(
      data => { // then
        this.contracts = data;

        this.subscription = this.activatedRoute.queryParams.subscribe((params: Params) => {
          this.message = params['message'];
        });

      }, error => { // catch
        console.log("Lay danh sach hop dong that bai")
      },
    );
  }

  sendId(id: number, name: string) {
    this.idDelete = id;
    this.nameDelete = name;
  }

  delete(idDelete: number) {
    this.contractService.deleteContractById(idDelete).subscribe(
      data => {
        this.getAllContract()
      }, error => { // catch
        console.log("Xoa khach hang that bai")
      },
      // () => { // finally
      //
      // }
    );
  }
}

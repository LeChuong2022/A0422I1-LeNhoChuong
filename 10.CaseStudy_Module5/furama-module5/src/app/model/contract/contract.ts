import {Customer} from "../customer/customer";
import {Service} from "../service/service";

export interface Contract {
  id?: number;
  codeContract?: string;
  customer?: Customer;
  service?: Service;
  dateStart?: string;
  dateEnd?: string;
  deposits?: number;
}

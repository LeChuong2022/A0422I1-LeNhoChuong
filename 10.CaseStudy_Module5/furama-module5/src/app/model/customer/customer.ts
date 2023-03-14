import {CustomerType} from "./customerType";

export interface Customer {
  id?: number;
  name?: string;
  dayOfBirth?: string;
  gender?: boolean;
  idCard?: string;
  phone?: string;
  email?: string;
  customerType?: CustomerType;
  address?: string;
}

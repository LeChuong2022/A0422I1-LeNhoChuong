import {RentType} from "./rentType";
import {AccompaniedService} from "./accompaniedService";
import {ServiceType} from "./serviceType";

export interface Service {
  id?: number;
  name?: string;
  serviceArea?: number;
  serviceCost?: number;
  serviceMaxPeople?: number;
  standardRoom?: string;
  descriptionOtherConvenience?: string;
  poolArea?: number;
  numberOfFloors?: number;

  rentType?: RentType;
  accompaniedService?: AccompaniedService;
  serviceType?: ServiceType;
}

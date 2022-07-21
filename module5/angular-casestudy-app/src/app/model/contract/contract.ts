import {Facility} from '../facility/facility';
import {Customer} from '../customer/customer';
import {Employee} from '../employee/employee';

export interface Contract {
  id?: number,
  startDate?: string,
  endDate?: string,
  deposit?: number,
  total?: number,
  employee?: Employee,
  customer?: Customer
  facility?: Facility
}

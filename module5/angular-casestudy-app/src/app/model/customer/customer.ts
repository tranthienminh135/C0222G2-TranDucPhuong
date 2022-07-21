import {CustomerType} from './customerType';

export interface Customer {
  id?: number,
  customerType?: CustomerType,
  name?: string,
  birthday?: string,
  gender?: number,
  idCard?: string,
  phoneNumber?: string,
  email?: string,
  address?: string
}

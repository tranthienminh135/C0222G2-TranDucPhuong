import {Product} from './product';

export interface Consignment {
  id?: number,
  code?: string,
  product?: Product,
  quantity?: number,
  dateIn?: string,
  dateOut?: string,
  dateEnd?: string,
  imgUrl?: string
}

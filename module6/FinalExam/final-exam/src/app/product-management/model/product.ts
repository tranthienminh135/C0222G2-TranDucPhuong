import {ProductType} from "./productType";
import {Order} from "./order";

export interface Product {
  id?: number,
  code?: string,
  name?: string,
  price?: number,
  status?: boolean,
  dateIn?: string,
  origin?: string,
  gas?: boolean,
  sweet?: boolean,
  author?: string,
  category?: string,
  publicDate?: string,
  productType?: ProductType,
  orderServices?: Order[],
  totalMoney?: number
}

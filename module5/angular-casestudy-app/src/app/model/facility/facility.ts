import {RentType} from './rentType';

export interface Facility {
  id?: number
  name?: string
  area?: number
  cost?: number
  maxPeople?: number
  rentType?: RentType
  standardRoom?: string
  descriptionOtherConvenience?: string
  numberOfFloors?: number
  poolArea?: number
  img?: string
}

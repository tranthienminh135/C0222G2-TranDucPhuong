import {EducationDegree} from './educationDegree';
import {Division} from './division';
import {EmployeePosition} from './employeePosition';

export interface Employee {
  id?: number,
  name?: string,
  birthday?: string,
  address?: string,
  idCard?: string,
  phoneNumber?: string,
  email?: string,
  salary?: number,
  educationDegree?: EducationDegree,
  division?: Division,
  position?: EmployeePosition
}

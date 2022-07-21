import {EducationDegree} from './educationDegree';
import {Division} from './division';
import {EmployeePosition} from './employeePosition';

export interface Employee {
  id?: number,
  name?: string,
  birthday?: string,
  idCard?: string,
  phoneNumber?: string,
  email?: string,
  educationDegree?: EducationDegree,
  division?: Division,
  position?: EmployeePosition
}

import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Employee} from '../../model/employee/employee';
import {HttpClient} from '@angular/common/http';
import {Division} from '../../model/employee/division';
import {EducationDegree} from '../../model/employee/educationDegree';
import {EmployeePosition} from '../../model/employee/employeePosition';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private URL_EMPLOYEE_PAGE = "http://localhost:8080/rest/employee";
  private URL_EMPLOYEE_LIST = "http://localhost:8080/rest/employee/list";
  private URL_EMPLOYEE_CREATE = "http://localhost:8080/rest/employee/create";
  private URL_EMPLOYEE_DELETE = "http://localhost:8080/rest/employee/delete/";
  private URL_EMPLOYEE_EDIT = "http://localhost:8080/rest/employee/edit";
  private URL_EMPLOYEE_FIND_BY_ID = "http://localhost:8080/rest/employee/find-by-id/";
  private URL_DIVISION = "http://localhost:8080/rest/division";
  private URL_POSITION = "http://localhost:8080/rest/position";
  private URL_EDUCATION_DEGREE = "http://localhost:8080/rest/education-degree";

  constructor(private httpClient: HttpClient) { }

  findAllPageEmployee(page:number, search: string): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.URL_EMPLOYEE_PAGE + '?page=' + page + '&searchValue=' + search);
  }
  findAllDivision(): Observable<Division[]> {
    return this.httpClient.get<Division[]>(this.URL_DIVISION);
  }
  findAllPosition(): Observable<EmployeePosition[]> {
    return this.httpClient.get<EmployeePosition[]>(this.URL_POSITION);
  }
  findAllEducationDegree(): Observable<EducationDegree[]> {
    return this.httpClient.get<EducationDegree[]>(this.URL_EDUCATION_DEGREE);
  }

  save(employee: Employee): Observable<Employee> {
    let employeeDto: Employee = new class implements Employee {
      address: string = employee.address;
      birthday: string = employee.birthday;
      division: Division = employee.division;
      educationDegree: EducationDegree = employee.educationDegree;
      email: string = employee.email;
      id: number;
      salary: number = employee.salary;
      idCard: string = employee.idCard;
      name: string = employee.name;
      phoneNumber: string = employee.phoneNumber;
      position: EmployeePosition = employee.position;
    };
    return this.httpClient.post(this.URL_EMPLOYEE_CREATE, employeeDto);
  }

  deleteEmployee(id: number): Observable<Employee> {
    return  this.httpClient.delete(this.URL_EMPLOYEE_DELETE + id);
  }

  findById(id: string): Observable<Employee> {
    return this.httpClient.get(this.URL_EMPLOYEE_FIND_BY_ID + id);
  }

  updateEmployee(employee: Employee): Observable<Employee> {
    return this.httpClient.patch(this.URL_EMPLOYEE_EDIT, employee);
  }
}

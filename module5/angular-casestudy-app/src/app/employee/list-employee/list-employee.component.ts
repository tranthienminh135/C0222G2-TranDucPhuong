import { Component, OnInit } from '@angular/core';
import {Employee} from '../../model/employee/employee';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
  employee: Employee[] = [];
  constructor() {
    this.employee = [
      {
        id: 0, name: 'Lê Thị Tài', birthday: '2022-02-02', idCard: '123456789', phoneNumber: '789456123', email: 'lethitaingu@gmail.com',
        educationDegree: {
          id: 0,
          name: 'THCS'
        },
        division: {
          id: 0,
          name: 'Sale'
        },
        position: {
          id: 0,
          name: 'Bảo vệ'
        }
      }
    ]
  }

  ngOnInit(): void {
  }

}

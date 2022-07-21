import { Component, OnInit } from '@angular/core';
import {Customer} from '../../model/customer/customer';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customer: Customer[] = [];
  constructor() {
    this.customer = [
      {
        id: 0,
        customerType: {
          id: 0,
          name: 'Diamond'
        },
        name: 'Lê Thị Tài', birthday: '2020-01-01', gender: 1, idCard: '123456789', phoneNumber: '456789123', email: 'lethitai@gmail.com',
        address: 'Số 8 đường Hoàng Hoa Thám'
      },
      {
        id: 1,
        customerType: {
          id: 0,
          name: 'Diamond'
        },
        name: 'Lê Thị Tài', birthday: '2020-01-01', gender: 0, idCard: '123456789', phoneNumber: '456789123', email: 'lethitai@gmail.com',
        address: 'Số 8 đường Hoàng Hoa Thám'
      },
      {
        id: 2,
        customerType: {
          id: 0,
          name: 'Diamond'
        },
        name: 'Lê Thị Tài', birthday: '2020-01-01', gender: 2, idCard: '123456789', phoneNumber: '456789123', email: 'lethitai@gmail.com',
        address: 'Số 8 đường Hoàng Hoa Thám'
      }
    ];
  }

  ngOnInit(): void {
  }

}

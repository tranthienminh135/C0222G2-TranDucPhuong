import { Component, OnInit } from '@angular/core';
import {Contract} from '../../model/contract/contract';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {
  contract: Contract[] = [];

  constructor() {
    this.contract = [
      {id: 0, startDate: '2020-09-16', endDate: '2021-03-12', deposit: 10000, total: 1000,
        employee: {id: 0, name: 'Lê Thị Tài'},
        customer: {id: 0, name: 'Lê Thị Hậu'},
        facility: {id: 0, name: 'PHÒNG SUIT HƯỚNG BIỂN'}
      },
      {id: 1, startDate: '2020-09-16', endDate: '2021-03-12', deposit: 10000, total: 1000,
        employee: {id: 0, name: 'Lê Thị Bình'},
        customer: {id: 0, name: 'Lê Thị Phúc'},
        facility: {id: 0, name: 'PHÒNG SUIT HƯỚNG ĐỐI TƯỢNG'}
      },
      {id: 2, startDate: '2020-09-16', endDate: '2021-03-12', deposit: 10000, total: 1000,
        employee: {id: 0, name: 'Lê Thị Hòa'},
        customer: {id: 0, name: 'Lê Thị Bảo'},
        facility: {id: 0, name: 'PHÒNG SUIT HƯỚNG HÀM'}
      },
      {id: 3, startDate: '2020-09-16', endDate: '2021-03-12', deposit: 10000, total: 1000,
        employee: {id: 0, name: 'Lê Thị Hiếu Lợn'},
        customer: {id: 0, name: 'Lê Thị Thông'},
        facility: {id: 0, name: 'PHÒNG SUIT HƯỚNG CẤU TRÚC'}
      },
      {id: 4, startDate: '2020-09-16', endDate: '2021-03-12', deposit: 10000, total: 1000,
        employee: {id: 0, name: 'Lê Thị Tuyến'},
        customer: {id: 0, name: 'Lê Thị Luận'},
        facility: {id: 0, name: 'PHÒNG SUIT HƯỚNG SỰ KIỆN'}
      }
    ]
  }

  ngOnInit(): void {
  }

}

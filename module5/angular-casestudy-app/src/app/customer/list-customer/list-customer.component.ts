import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer/customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../model/customer/customerType';
import {CustomerService} from '../../service/customer/customer.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css'],
  providers: [CustomerService]
})
export class ListCustomerComponent implements OnInit {
  customers: Customer[] = [];
  customerType: CustomerType[] = [];
  customerFormCreate: FormGroup;

  constructor(private customerService: CustomerService) {
    this.customerFormCreate = new FormGroup({
      id: new FormControl(),
      customerType: new FormControl(),
      name: new FormControl(),
      birthday: new FormControl(),
      gender: new FormControl(),
      idCard: new FormControl(),
      phoneNumber: new FormControl(),
      email: new FormControl(),
      address: new FormControl()
    });
    this.getAllCustomer();
  }

  getAllCustomer() {
    this.customerService.findAll(0,'').subscribe(data => {
      // @ts-ignore
      data.content.map(value => {
        this.customers.push(value)
      })
    });
  }

  ngOnInit(): void {

  }

  createCustomer() {
    console.log(this.customerFormCreate.value.customerType);
    if (this.customerFormCreate.valid) {
      let max = 0;
      for (const e of this.customers) {
        if (e.id > max) {
          max = e.id;
        }
      }
      this.customerFormCreate.value.id = (max + 1);
      this.customers.push(this.customerFormCreate.value);
      this.customerFormCreate.reset();
      // @ts-ignore
      $('#staticBackdrop').modal('hide');
    }
  }
}

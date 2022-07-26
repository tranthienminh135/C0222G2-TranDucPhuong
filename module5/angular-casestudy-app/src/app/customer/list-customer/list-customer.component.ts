import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer/customer';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../model/customer/customerType';
import {CustomerService} from '../../service/customer/customer.service';
import {ToastrService} from 'ngx-toastr';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css'],
  providers: [CustomerService]
})
export class ListCustomerComponent implements OnInit {
  customers: Customer[] = [];
  customerTypes: CustomerType[] = [];
  customerFormCreate: FormGroup;
  errCustomerType: string[];
  errName: string[];
  errBirthday: string[];
  errGender: string[];
  errIdCard: string[];
  errPhoneNumber: string[]
  errEmail: string[];
  errAddress: string[];

  constructor(private customerService: CustomerService, private toastrService: ToastrService, private activatedRoute: ActivatedRoute) {
    this.customerFormCreate = new FormGroup({
      customerType: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      birthday: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      idCard: new FormControl('', [Validators.required]),
      phoneNumber: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl('', [Validators.required])
    });
  }

  findAllCustomer() {
    this.customerService.getAllCustomers().subscribe((data) => {
      this.customers = data;
    })
  }

  ngOnInit(): void {
    this.customerService.getAllCustomerTypes().subscribe((data) => {
      this.customerTypes = data;
    })
    this.findAllCustomer();
  }

  checkIdCardExists(idCard: AbstractControl) {

    return null;
  }

  createCustomer() {
    if (this.customerFormCreate.valid) {
      this.customerService.save(this.customerFormCreate.value).subscribe(value => {
        // @ts-ignore
        $('#staticBackdropCreate').modal('hide');
        this.toastrService.success("Success!", "Create");
        this.customerFormCreate.reset();
        this.findAllCustomer();
      });
    } else {
      if (this.customerFormCreate.controls.customerType.errors !== null) {
        this.errCustomerType = Object.keys(this.customerFormCreate.controls.customerType.errors);
      } else {
        this.errCustomerType = [];
      }
      if (this.customerFormCreate.controls.name.errors !== null) {
        this.errName = Object.keys(this.customerFormCreate.controls.name.errors);
      } else {
        this.errName = [];
      }
      if (this.customerFormCreate.controls.birthday.errors !== null) {
        this.errBirthday = Object.keys(this.customerFormCreate.controls.birthday.errors);
      } else {
        this.errBirthday = [];
      }
      if (this.customerFormCreate.controls.gender.errors !== null) {
        this.errGender = Object.keys(this.customerFormCreate.controls.gender.errors);
      } else {
        this.errGender = [];
      }
      if (this.customerFormCreate.controls.idCard.errors !== null) {
        this.errIdCard = Object.keys(this.customerFormCreate.controls.idCard.errors);
      } else {
        this.errIdCard = [];
      }
      if (this.customerFormCreate.controls.phoneNumber.errors !== null) {
        this.errPhoneNumber = Object.keys(this.customerFormCreate.controls.phoneNumber.errors);
      } else {
        this.errPhoneNumber = [];
      }
      if (this.customerFormCreate.controls.email.errors !== null) {
        this.errEmail = Object.keys(this.customerFormCreate.controls.email.errors);
      } else {
        this.errEmail = [];
      }
      if (this.customerFormCreate.controls.address.errors !== null) {
        this.errAddress = Object.keys(this.customerFormCreate.controls.address.errors);
      } else {
        this.errAddress = [];
      }
    }
  }

  deleteCustomer(id: number) {
    this.customerService.delete(id).subscribe(value => {
      // @ts-ignore
      $('#staticBackdropDelete' + id).modal('hide');
      this.toastrService.success("Success!", "Delete");
      this.findAllCustomer();
    });
  }
}

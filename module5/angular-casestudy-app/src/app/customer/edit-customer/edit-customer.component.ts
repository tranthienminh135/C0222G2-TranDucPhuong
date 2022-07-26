import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../model/customer/customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer/customer.service';
import {CustomerType} from '../../model/customer/customerType';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  customer: Customer = {};
  customerFormEdit: FormGroup;
  customerTypes: CustomerType[];

  constructor(private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private toastrService: ToastrService,
              private router: Router) {
    this.customerFormEdit = new FormGroup({
      id: new FormControl(''),
      customerType: new FormControl(''),
      name: new FormControl(''),
      birthday: new FormControl(''),
      gender: new FormControl(''),
      idCard: new FormControl(''),
      phoneNumber: new FormControl(''),
      email: new FormControl(''),
      address: new FormControl('')
    });
  }

  ngOnInit(): void {
    this.customerService.getAllCustomerTypes().subscribe(value => {
      this.customerTypes = value;
    });
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.customerService.findById(id).subscribe(value => {
        this.customer = value;
        this.customerFormEdit = new FormGroup({
          id: new FormControl(this.customer.id),
          customerType: new FormControl(this.customer.customerType, [Validators.required]),
          name: new FormControl(this.customer.name, [Validators.required]),
          birthday: new FormControl(this.customer.birthday, [Validators.required]),
          gender: new FormControl(this.customer.gender, [Validators.required]),
          idCard: new FormControl(this.customer.idCard, [Validators.required]),
          phoneNumber: new FormControl(this.customer.phoneNumber, [Validators.required]),
          email: new FormControl(this.customer.email, [Validators.required, Validators.email]),
          address: new FormControl(this.customer.address, [Validators.required])
        });
      });
    });
  }

  editCustomer() {
    this.customerService.update(this.customerFormEdit.value).subscribe(value => {
      this.toastrService.success("Success!", "Edit");
      this.router.navigateByUrl("/customer-list").then();
    });
  }

  compareCustomerType(c1: CustomerType, c2: CustomerType): boolean {
    if ((c1 && c2) !== undefined) {
      return c1.id === c2.id;
    }
  }

  compareGender(c1: string, c2: string): boolean {
    return c1 === c2;
  }
}

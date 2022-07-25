import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {Customer} from '../../model/customer';
import {FormControl, FormGroup} from '@angular/forms';
import {CustomerService} from '../../service/customer/customerService';

@Component({
  selector: 'app-modal-edit-customer',
  templateUrl: './modal-edit-customer.component.html',
  styleUrls: ['./modal-edit-customer.component.css']
})
export class ModalEditCustomerComponent implements OnInit, OnChanges {

  @Input('ctme') customerChild: Customer;
  customerForm: FormGroup;

  @Output() childChanged: EventEmitter<Customer> = new EventEmitter<Customer>();

  constructor(private customerService: CustomerService) {}

  ngOnInit(): void {
  }

  editCustomer() {
    this.childChanged.emit(this.customerForm.value);
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.customerForm = new FormGroup({
      id: new FormControl(this.customerChild.id),
      name: new FormControl(this.customerChild.name),
      age: new FormControl(this.customerChild.age)
    })
  }
}

import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {CustomerService} from '../../service/customer/customerService';
import {Customer} from '../../model/customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
  customerParent: Customer;
  private customerService;
  message: string;

  constructor() {
    this.customerService = new CustomerService();
    this.customers = this.customerService.getAllCustomer();
    this.customerParent = this.customers[0];
  }

  ngOnInit(): void {
  }

  showModalDelete(element: Customer) {
    this.customerParent = element;
    setTimeout(function() {
      // @ts-ignore
      $('#exampleModalCreate' + element.id).modal('show');
    }, 1)
  }

  deleteCustomer(id: number) {
    this.message = "You just deleted customer " + this.customerService.findById(id).name + " with id = " + id;
    console.log(id);
    if (this.customerService.delete(id)) {
      // @ts-ignore
      $('#exampleModalCreate' + id).modal('hide');
      // @ts-ignore
      $('#exampleModalMessage').modal('show');
    } else {
      console.log(false);
    }
  }

  showModalEdit(element: Customer) {
    this.customerParent = element;
    setTimeout(function() {
      // @ts-ignore
      $('#exampleModalEdit' + element.id).modal('show');
    }, 10)
  }

  editCustomer(element: Customer) {
    this.customerService.saveCustomer(element);
    setTimeout(function() {
      // @ts-ignore
      $('#exampleModalEdit' + element.id).modal('hide');
    }, 10)
    this.message = "Edit customer"
    // @ts-ignore
    $('#exampleModalMessage').modal('show');
  }
}

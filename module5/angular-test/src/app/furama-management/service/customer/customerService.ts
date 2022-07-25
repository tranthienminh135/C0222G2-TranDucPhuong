import {Customer} from '../../model/customer';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [];

  constructor() {
    this.customers.push(new Customer(0, 'Tai ngu', 15));
    this.customers.push(new Customer(1, 'Le thi Tai', 16));
    this.customers.push(new Customer(2, 'Le Thi Hau', 17));
    this.customers.push(new Customer(3, 'Le Thi Tri', 18));
    this.customers.push(new Customer(4, 'Le Thi Hoan', 19));
    this.customers.push(new Customer(5, 'Le Thi Binh', 20));
  }

  public getAllCustomer() {
    return this.customers;
  }

  public delete(id: number) {
    let customers: Customer[] = this.getAllCustomer();
    for (let i = 0; i < customers.length; i++) {
      if (customers[i].id == id) {
        customers.splice(i, 1);
        return true;
      }
    }
    return false;
  }

  saveCustomer(customer: Customer) {
    for (let i = 0; i < this.customers.length; i++) {
      if (customer.id == this.customers[i].id) {
        this.customers[i].name = customer.name;
        this.customers[i].age = customer.age;
        break;
      }
    }
  }

  findById(idCustomer: number): Customer {
    for (let i = 0; i < this.customers.length; i++) {
      if (this.customers[i].id == idCustomer) {
        return this.customers[i];
      }
    }
  }
}

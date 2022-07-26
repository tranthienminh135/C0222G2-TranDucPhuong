import {Injectable} from '@angular/core';
import {Customer} from '../../model/customer/customer';
import {CustomerType} from '../../model/customer/customerType';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private URL_CUSTOMER = 'http://localhost:3000/customer';
  private URL_CUSTOMER_TYPE = 'http://localhost:3000/customerType';

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomers(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.URL_CUSTOMER);
  }

  getAllCustomerTypes(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(this.URL_CUSTOMER_TYPE);
  }

  save(customer: Customer): Observable<Customer> {
    customer.gender = +customer.gender;
    return this.httpClient.post<Customer>(this.URL_CUSTOMER, customer);
  }

  delete(id: number): Observable<Customer> {
    return this.httpClient.delete(this.URL_CUSTOMER + '/' + id);
  }

  findById(id: string): Observable<Customer> {
    return this.httpClient.get(this.URL_CUSTOMER + '/' + id);
  }

  update(customer: Customer): Observable<Customer> {
    return this.httpClient.patch<Customer>(this.URL_CUSTOMER + '/' + customer.id, customer);
  }
}

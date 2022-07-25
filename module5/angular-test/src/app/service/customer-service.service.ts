import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  constructor(private customerService: HttpClient) {
  }

  getData() {
    let url = 'http://localhost:8080/rest/customer';
    return this.customerService.get(url);
  }

  deleteData(id: number) {
    let url = 'http://localhost:8080/rest/customer/delete/' + id;
    return this.customerService.delete(url);
  }
}

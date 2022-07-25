import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(page: number, search: string) {
    let url = 'http://localhost:8080/rest/customer?page=' + page + '&searchValue=' + search;
    return this.httpClient.get(url);
  }
}

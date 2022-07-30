import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Product} from '../../model/product';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_PRODUCT = "http://localhost:8080/rest/product";

  constructor(private httpClient: HttpClient) { }

  findAllProduct(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.URL_PRODUCT + "/list");
  }
}

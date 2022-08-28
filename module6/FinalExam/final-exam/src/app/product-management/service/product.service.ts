import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private LIST_URL = "http://localhost:8080/product/list"
  private CREATE_URL = "http://localhost:8080/product/create"
  private DELETE_URL = "http://localhost:8080/product/delete"

  constructor(private httpClient: HttpClient) { }

  findAll():Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.LIST_URL);
  }

  save(value: Product):Observable<Product> {
    return this.httpClient.post(this.CREATE_URL, value);
  }

  deleteProduct(id: number): Observable<Product> {
    return this.httpClient.delete(this.DELETE_URL + "/" + id);
  }
}

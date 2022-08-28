import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductType} from "../model/productType";

@Injectable({
  providedIn: 'root'
})
export class ProductTypeService {
  private LIST_URL = "http://localhost:8080/product-type/list"

  constructor(private httpClient: HttpClient) { }

  findAll():Observable<ProductType[]> {
    return this.httpClient.get<ProductType[]>(this.LIST_URL);
  }
}

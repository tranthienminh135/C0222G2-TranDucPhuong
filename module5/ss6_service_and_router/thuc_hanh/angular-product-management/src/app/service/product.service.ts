import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {Category} from "../model/category";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  categories: Category[] = []
  products: Product[] = [];

  private URL_PRODUCT: string = "http://localhost:3000/product";
  private URL_CATEGORY: string = "http://localhost:3000/category";

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.URL_PRODUCT);
  }

  saveProduct(product: Product): Observable<Product> {
    return this.httpClient.post(this.URL_PRODUCT, product);
  }

  findById(id: number): Observable<Product> {
    return this.httpClient.get(this.URL_PRODUCT + "/" + id);
  }

  remove(idDelete: number): Observable<Product> {
    return  this.httpClient.delete(this.URL_PRODUCT + '/' + idDelete);
  }

  getAllCategories(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.URL_CATEGORY);
  }

  updateProduct(product: Product): Observable<Product> {
    return this.httpClient.patch(this.URL_PRODUCT + '/' + product.id, product);
  }
}

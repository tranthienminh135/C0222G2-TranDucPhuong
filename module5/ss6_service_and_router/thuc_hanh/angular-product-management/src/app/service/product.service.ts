import {Injectable} from '@angular/core';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];

  constructor() {
  }

  getAll() {
    return this.products;
  }

  saveProduct(product) {
    let checkExists = this.products.some((value => value.id === product.id));
    if (checkExists) {
      let index = this.products.findIndex((value => value.id === product.id));
      this.products[index].id = product.id;
      this.products[index].name = product.name;
      this.products[index].price = product.price;
      this.products[index].description = product.description;
    } else {
      this.products.push(product);
    }
  }

  findById(id: number) {
    return this.products[this.products.findIndex(value => value.id === id)];
  }

  remove(idDelete: number) {
    this.products.splice(this.products.findIndex((product) => product.id === idDelete), 1);
  }
}

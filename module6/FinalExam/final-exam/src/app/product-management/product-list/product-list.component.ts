import { Component, OnInit } from '@angular/core';
import {Product} from "../model/product";
import {ProductService} from "../service/product.service";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  p: number = 0;

  constructor(private productService: ProductService,
              private toastrService: ToastrService,
              private title: Title) {
    this.title.setTitle("Danh sách sản phẩm");
  }

  ngOnInit(): void {
    this.getAllProduct();
  }

  getAllProduct() {
    this.productService.findAll().subscribe(value => {
      this.products = value;
    }, error => {}, () => {
      for (let i = 0; i < this.products.length ; i++) {
        this.products[i].totalMoney = 0;
        for (let j = 0; j < this.products[i].orderServices.length ; j++) {
          this.products[i].totalMoney += this.products[i].orderServices[j].quantity;
        }
      }
    })
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(value => {
      this.toastrService.success("Xóa thành công!")
      this.ngOnInit();
      //@ts-ignore
      $('#staticBackdropDelete' + id).modal('hide');
    });
  }
}

import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {ActivatedRoute, Router} from "@angular/router";
import {Category} from "../../model/category";
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  categories: Category[] = [];

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute, private router: Router,
              private authService: AuthService) {
    this.activatedRoute.paramMap.subscribe(value => {
      if (value.get('idDelete') != null) {
        const idDelete = parseInt(value.get('idDelete'));
        this.productService.remove(idDelete).subscribe(value1 => {
          this.router.navigateByUrl("/product/list").then(() => {
            alert("Delete success!");
          })
        });
      }
    })
  }

  ngOnInit() {
    this.getAllProduct();
  }

  getAllProduct() {
    this.productService.getAllCustomer().subscribe(value => {
      this.products = value;
    });
  }

  getAllCategories() {
    this.productService.getAllCategories();
  }

  onLogout() {
    this.authService.logout();
    console.log(this.authService.isAuthorized)
    if (!this.authService.isAuthorized) {
      this.router.navigateByUrl("/login").then()
    }
  }
}

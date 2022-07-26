import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../model/product";
import {Category} from "../../model/category";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  categories: Category[] = [];
  product: Product = {};
  productFormCreate: FormGroup;


  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {

  }

  ngOnInit() {
    this.productService.getAllCategories().subscribe(value => {
      this.categories = value;
    }, error => {}, () => {
      this.productFormCreate = new FormGroup({
        name: new FormControl(),
        price: new FormControl(),
        description: new FormControl(),
        category: new FormControl()
      });
    })
  }

  submit() {
    console.log(this.productFormCreate.value);
    this.productService.saveProduct(this.productFormCreate.value).subscribe(value => {
      this.router.navigateByUrl("/product/list").then(() => {
        alert("Create success!");
      })
    });
  }
}

import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  title: string = 'Thêm mới sản phẩm';
  buttonName: string = 'Thêm';

  product: Product = {};
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  });

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    activatedRoute.paramMap.subscribe((paramMap) => {
      let id = null;
      if (paramMap.get('idEdit') !== null) {
        id = parseInt(paramMap.get('idEdit'));
        this.product = this.productService.findById(id);
      }
      if (id !== null) {
        this.productForm = new FormGroup({
          id: new FormControl(this.product.id),
          name: new FormControl(this.product.name),
          price: new FormControl(this.product.price),
          description: new FormControl(this.product.description),
        });
        this.title = 'Chỉnh sửa sản phẩm';
        this.buttonName = 'Sửa';
      }
    })
  }

  ngOnInit() {
  }

  submit() {
    const product = this.productForm.value;
    this.productService.saveProduct(product);
    this.productForm.reset();
    this.router.navigateByUrl('/product/list')
      .then(value => {

      }).catch(reason => {

      }).finally(() => {
    });
  }
}

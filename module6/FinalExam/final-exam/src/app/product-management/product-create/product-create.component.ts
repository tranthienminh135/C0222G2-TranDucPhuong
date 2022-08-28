import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductTypeService} from "../service/product-type.service";
import {ProductType} from "../model/productType";
import {ProductService} from "../service/product.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {Product} from "../model/product";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  productTypes: ProductType[] = [];
  productForm: FormGroup;

  constructor(private productTypeService: ProductTypeService,
              private productService: ProductService,
              private toastrService: ToastrService,
              private router: Router,
              private title: Title) {
    this.title.setTitle("Thêm mói sản phẩm")
  }

  ngOnInit(): void {
    this.getAllProductType();
  }

  getAllProductType() {
    this.productTypeService.findAll().subscribe(value => {
      this.productTypes = value;
    }, error => {
    }, () => {
      this.createForm();
    });
  }

  createForm() {
    this.productForm = new FormGroup({
      code: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      status: new FormControl('', [Validators.required]),
      dateIn: new FormControl('', [Validators.required]),
      origin: new FormControl(),
      gas: new FormControl(),
      sweet: new FormControl(),
      author: new FormControl(),
      category: new FormControl(),
      publicDate: new FormControl(),
      productType: new FormControl('', [Validators.required])
    })
  }

  onCreate() {
    const product: Product = this.productForm.value;
    product.productType = {
      id: this.productForm.value.productType
    }
    if (this.productForm.valid) {
      this.productService.save(product).subscribe(value => {
        this.router.navigateByUrl("/product/list").then(value1 => {
          this.toastrService.success("Thêm mới thành công!")
        })
      }, error => {
        if (error.error.code == 'CodeExists') {
          this.productForm.controls.code.setErrors({'CodeExists': true})
        }
      });
    } else {
      this.toastrService.warning("Vui lòng nhập dữ liệu")
    }
  }

  getProductType(target: any) {
    switch (target.value[3]) {
      case '1':
        //@ts-ignore
        $('#do-uong').show();
        //@ts-ignore
        $('#do-an').hide();
        //@ts-ignore
        $('#sach').hide();
        break;
      case '2':
        //@ts-ignore
        $('#do-uong').hide();
        //@ts-ignore
        $('#do-an').show();
        //@ts-ignore
        $('#sach').hide();
        break;
      case '3':
        //@ts-ignore
        $('#sach').show();
        //@ts-ignore
        $('#do-uong').hide();
        //@ts-ignore
        $('#do-an').hide();
        break;
    }
  }
}

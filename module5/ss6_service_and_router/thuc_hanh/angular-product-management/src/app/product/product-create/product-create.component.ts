import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../model/product";
import {Category} from "../../model/category";
import {AngularFireStorage} from "@angular/fire/storage";
import {finalize} from "rxjs/operators";
import {AngularFireDatabase} from "@angular/fire/database";
import {formatDate} from "@angular/common";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  categories: Category[] = [];
  product: Product = {};
  productFormCreate: FormGroup;
  selectedImage: any = null;
  urlImg: string;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              @Inject(AngularFireStorage) private storage: AngularFireStorage) {

  }

  ngOnInit() {
    this.productService.getAllCategories().subscribe(value => {
      this.categories = value;
    }, error => {}, () => {
      this.productFormCreate = new FormGroup({
        name: new FormControl(),
        price: new FormControl(),
        description: new FormControl(),
        imgUrl: new FormControl(),
        category: new FormControl()
      });
    })
  }

  submit() {
    const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
    const fileRef = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {
        fileRef.getDownloadURL().subscribe((url) => {
          this.product = this.productFormCreate.value;
          this.product.imgUrl = url;
          this.productService .saveProduct(this.product).subscribe(value => {
            this.router.navigateByUrl("/product/list").then(() => {
              alert("Create success!");
            })
          });
        });
      })
    ).subscribe();
  }

  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
  }

  private getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }
}

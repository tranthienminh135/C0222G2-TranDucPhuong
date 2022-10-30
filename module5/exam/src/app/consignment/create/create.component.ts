import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Product} from '../../../model/product';
import {ProductService} from '../../service/product.service';
import {ConsignmentService} from '../../service/consignment.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {formatDate} from '@angular/common';
import {finalize} from 'rxjs/operators';
import {AngularFireStorage} from '@angular/fire/storage';
import {Consignment} from '../../../model/consignment';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  consignmentForm: FormGroup;
  products: Product[] = [];
  selectedImage: any;
  consignment: Consignment = {};

  constructor(private productService: ProductService,
              private consignmentService: ConsignmentService,
              private toastrService: ToastrService,
              private router: Router,
              @Inject(AngularFireStorage) private storage: AngularFireStorage) { }

  ngOnInit(): void {
    this.productService.findAllProduct().subscribe(value => {
      this.products = value;
    }, error => {}, () => {
      this.createForm();
    });
  }

  createForm() {
    this.consignmentForm = new FormGroup({
      code: new FormControl('', [Validators.required, Validators.pattern('^LH-[0-9]{4}$')]),
      product: new FormControl('', Validators.required),
      quantity: new FormControl('', [Validators.required, Validators.min(0)]),
      dateIn: new FormControl('', Validators.required),
      dateOut: new FormControl('', Validators.required),
      dateEnd: new FormControl('', Validators.required),
      imgUrl: new FormControl('', Validators.required)
    })
  }

  createConsignment() {
    const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
    const fileRef = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {
        fileRef.getDownloadURL().subscribe((url) => {
          this.consignment = this.consignmentForm.value;
          this.consignment.imgUrl = url;
          console.log(this.consignment);
          if (this.consignmentForm.valid) {
            this.consignmentService.createConsignment(this.consignmentForm.value).subscribe(value => {

            }, error => {}, () => {
              this.consignmentForm.reset();
              this.router.navigateByUrl("/list").then(value => {
                this.toastrService.success("Create success!");
              })
            });
          } else {
            this.toastrService.error("Something Wrong! enter data please!");
          }
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

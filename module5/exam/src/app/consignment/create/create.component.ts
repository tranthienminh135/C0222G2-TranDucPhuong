import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Product} from '../../../model/product';
import {ProductService} from '../../service/product.service';
import {ConsignmentService} from '../../service/consignment.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  consignmentForm: FormGroup;
  products: Product[] = [];

  constructor(private productService: ProductService,
              private consignmentService: ConsignmentService,
              private toastrService: ToastrService,
              private router: Router) { }

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
      dateEnd: new FormControl('', Validators.required)
    })
  }

  createConsignment() {
    if (this.consignmentForm.valid) {
      this.consignmentService.saveConsignment(this.consignmentForm.value).subscribe(value => {

      }, error => {}, () => {
        this.consignmentForm.reset();
        this.router.navigateByUrl("/list").then(value => {
          this.toastrService.success("Create success!");
        })
      });
    } else {
      this.toastrService.error("Something Wrong! enter data please!");
    }
  }
}

import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Route, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Consignment} from '../../../model/consignment';
import {ProductService} from '../../service/product.service';
import {ConsignmentService} from '../../service/consignment.service';
import {Product} from '../../../model/product';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  consignmentFormEdit: FormGroup;
  products: Product[] = [];
  product: Product = {};
  consignment: Consignment = {};

  constructor(private activatedRoute: ActivatedRoute,
              private consignmentService: ConsignmentService,
              private productService: ProductService,
              private toastrService: ToastrService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(value => {
       const id = parseInt(value.get('id'));
      this.consignmentService.findById(id).subscribe(value => {
        this.consignment = value;
    }, error => {}, () => {
        this.productService.findAllProduct().subscribe((val: Product[]) => {
          this.products = val;
          this.createForm(this.consignment);
        })
      });
    });
  }

  createForm(consignment: Consignment) {
    this.consignmentFormEdit = new FormGroup({
      id: new FormControl(consignment.id),
      code: new FormControl(consignment.code, [Validators.required, Validators.pattern('^LH-[0-9]{4}$')]),
      product: new FormControl(consignment.product, Validators.required),
      quantity: new FormControl(consignment.quantity, [Validators.required, Validators.min(0)]),
      dateIn: new FormControl(consignment.dateIn, Validators.required),
      dateOut: new FormControl(consignment.dateOut, Validators.required),
      dateEnd: new FormControl(consignment.dateEnd, Validators.required)
    });
  }

  editConsignment() {
    console.log(this.consignmentFormEdit.value);
    this.consignmentService.update(this.consignmentFormEdit.value).subscribe(value => {
    }, error => {}, () => {
      this.router.navigateByUrl("/list").then(value => {
        this.toastrService.success("Edit success!");
      })
    });
  }

  compareConsignment(c1: Consignment, c2: Consignment) {
    if (c1 && c2 != null) {
      return c1.id === c2.id;
    }
  }
}

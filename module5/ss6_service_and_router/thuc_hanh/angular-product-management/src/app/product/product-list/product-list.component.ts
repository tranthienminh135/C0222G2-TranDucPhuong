import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute,private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap) => {
      if (paramMap.get('idDelete') !== null) {
        this.productService.remove(parseInt(paramMap.get('idDelete')));
        this.router.navigateByUrl('/product/list').then(value => {
        })
      }
    })
  }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.products = this.productService.getAll();
  }

}

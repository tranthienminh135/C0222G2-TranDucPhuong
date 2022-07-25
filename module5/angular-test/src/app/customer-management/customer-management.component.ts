import {Component, OnInit} from '@angular/core';
import {CustomerServiceService} from '../service/customer-service.service';
import {Customer} from '../model/customer/customer';

@Component({
  selector: 'app-customer-management',
  templateUrl: './customer-management.component.html',
  styleUrls: ['./customer-management.component.css']
})
export class CustomerManagementComponent implements OnInit {
  customers: Customer[];
  idParent: number;

  constructor(private customerService: CustomerServiceService) {
    this.getDataFormAPI();
  }

  ngOnInit(): void {
  }

  showModal(id: number) {
    this.idParent = id;
    setTimeout(() => {
      // @ts-ignore
      $('#exampleModalDelete' + id).modal('show');
    }, 1);

  }

  getDataFormAPI() {
    this.customerService.getData().subscribe((data) => {
      // @ts-ignore
      this.customers = data.content.map((element) => {
        return element;
      });
    });
  }

  deleteCustomer(id: number) {
    this.customerService.deleteData(id).subscribe({
      next: value => {
        this.getDataFormAPI();
        setTimeout(() => {
          // @ts-ignore
          $('#exampleModalDelete' + id).modal('hide');
        }, 1);
      },
      error: err => {
        console.log(err);
      }
    });
  }
}

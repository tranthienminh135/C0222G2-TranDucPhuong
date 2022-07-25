import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Customer} from '../../model/customer';

@Component({
  selector: 'app-modal-create-customer',
  templateUrl: './modal-create-customer.component.html',
  styleUrls: ['./modal-create-customer.component.css']
})
export class ModalCreateCustomerComponent implements OnInit {

  @Input('ctmd') customerChild: Customer;
  childIdDelete: number = 0;

  @Output() childIdChanged: EventEmitter<number> = new EventEmitter<number>();

  sendId(id: number) {
    this.childIdDelete = id;
    this.childIdChanged.emit(this.childIdDelete);
  }
  constructor() {
  }

  ngOnInit(): void {
  }

}

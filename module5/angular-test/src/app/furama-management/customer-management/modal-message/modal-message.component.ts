import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';

@Component({
  selector: 'app-modal-message',
  templateUrl: './modal-message.component.html',
  styleUrls: ['./modal-message.component.css']
})
export class ModalMessageComponent implements OnInit {

  @Input('mes') message: string;

  constructor() { }

  ngOnInit(): void {
  }

}

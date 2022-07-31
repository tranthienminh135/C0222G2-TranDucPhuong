import { Component, OnInit } from '@angular/core';
import {ConsignmentService} from '../service/consignment.service';
import {Consignment} from '../../model/consignment';
import {ToastrService} from 'ngx-toastr';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-consignment',
  templateUrl: './consignment.component.html',
  styleUrls: ['./consignment.component.css']
})
export class ConsignmentComponent implements OnInit {
  consignments: Consignment[] = [];
  p: number = 0;
  searchForm: FormGroup;
  totalPages: number;
  number: number;
  countTotalPages: number[];

  constructor(private consignmentService: ConsignmentService, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.getAllConsignment(0);
    this.createSearchForm();
  }

  createSearchForm() {
    this.searchForm = new FormGroup({
      nameSearch: new FormControl(),
      startDate: new FormControl(),
      endDate: new FormControl(),
      dateEndSearch: new FormControl()
    })
  }

  getAllConsignment(page: number) {
    this.consignmentService.findAllConsignment(page).subscribe((data: Consignment[]) => {
      // @ts-ignore
      this.totalPages = data.totalPages;
      // @ts-ignore
      this.countTotalPages = new Array(data.totalPages);
      // @ts-ignore
      this.number = data.number;
      // @ts-ignore
      this.consignments = data.content;
    });
  }

  deleteConsignment(id: number) {
    this.consignmentService.deleteConsignment(id).subscribe(value => {
    }, error => {}, () => {
      // @ts-ignore
      $("#staticBackdropDelete" + id).modal('hide');
      this.getAllConsignment(0);
      this.toastrService.success("Delete success!");
    });
  }

  searchConsignment() {
    this.consignmentService.searchConsignment(this.searchForm.value).subscribe((value: Consignment[]) => {
      // @ts-ignore
      this.consignments = value.content;
    });
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getAllConsignment(numberPage);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAllConsignment(numberPage);
    }
  }

  goItem(i: number) {
    this.getAllConsignment(i);
  }
}

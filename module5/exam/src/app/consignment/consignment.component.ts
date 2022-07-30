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

  constructor(private consignmentService: ConsignmentService, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.getAllConsignment();
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

  getAllConsignment() {
    this.consignmentService.findAllConsignment().subscribe((data: Consignment[]) => {
      this.consignments = data;
    });
  }

  deleteConsignment(id: number) {
    this.consignmentService.deleteConsignment(id).subscribe(value => {

    }, error => {}, () => {
      // @ts-ignore
      $("#staticBackdropDelete" + id).modal('hide');
      this.getAllConsignment();
      this.toastrService.success("Delete success!");
    });
  }

  searchConsignment() {
    this.consignmentService.searchConsignment(this.searchForm.value).subscribe(value => {
      this.consignments = value;
    });
  }
}

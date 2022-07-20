import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-facility',
  templateUrl: './edit-facility.component.html',
  styleUrls: ['./edit-facility.component.css']
})
export class EditFacilityComponent implements OnInit {

  facilityValue: string = '';
  classInput = 'd-none';

  constructor() { }

  ngOnInit(): void {
  }


  changeFacility(value: string) {
    this.facilityValue = value;
    this.classInput = 'block';
  }
}

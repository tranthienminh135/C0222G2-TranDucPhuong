import {Component, OnInit} from '@angular/core';
import {Employee} from '../../model/employee/employee';
import {EmployeeService} from '../../service/employee/employee.service';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {Division} from '../../model/employee/division';
import {EducationDegree} from '../../model/employee/educationDegree';
import {EmployeePosition} from '../../model/employee/employeePosition';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
  employeePage: Employee[] = [];
  divisions: Division[] = [];
  positions: EmployeePosition[] = [];
  educationDegrees: EducationDegree[] = [];
  employeeForm: FormGroup;
  employeeList: Employee[] = [];
  totalPages: number[];
  pageNumber: number = 0;
  size: number;
  searchForm: FormGroup;
  isLoad: boolean = false;

  constructor(private employeeService: EmployeeService,
              private toastrService: ToastrService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllEmployee(this.pageNumber, '');
    this.getAllDivision();
    this.getAllPosition();
    this.getAllEducationDegree();
    this.searchForm = new FormGroup({
      name: new FormControl('')
    });
    this.employeeForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      birthday: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      idCard: new FormControl('', [Validators.required]),
      phoneNumber: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      salary: new FormControl('', [Validators.required]),
      educationDegree: new FormControl('', [Validators.required]),
      division: new FormControl('', [Validators.required]),
      position: new FormControl('', [Validators.required])
    });
  }

  getAllEmployee(pageNumber: number, search: string) {
    this.employeeService.findAllPageEmployee(pageNumber, search).subscribe(value => {
      // @ts-ignore
      this.employeeList = value.content;
      this.employeePage = value;
      // @ts-ignore
      this.totalPages = new Array(this.employeePage.totalPages);
      // @ts-ignore
      this.size = this.employeePage.size;
    }, error => {}, () => {
      // @ts-ignore
      if (this.employeePage.content.length != 0) {
        this.isLoad = false;
      }
      setTimeout(() => {
        // @ts-ignore
        if (this.employeePage.content.length == 0) {
          this.isLoad = null;
        } else {
          this.isLoad = true;
        }
      }, 1000);
    });
  }

  getAllDivision() {
    this.employeeService.findAllDivision().subscribe(value => {
      this.divisions = value;
    });
  }

  getAllPosition() {
    this.employeeService.findAllPosition().subscribe(value => {
      this.positions = value;
    });
  }

  getAllEducationDegree() {
    this.employeeService.findAllEducationDegree().subscribe(value => {
      this.educationDegrees = value;
    });
  }

  createEmployee() {
    if (this.employeeForm.valid) {
      this.employeeService.save(this.employeeForm.value).subscribe(value => {
        this.toastrService.success('Success!', 'Create');
        // @ts-ignore
        $('#staticBackdropCreate').modal('hide');
        this.employeeForm.reset();
        this.ngOnInit();
      }, err => {
        this.toastrService.error('Something wrong!', 'Edit');
        for (const e of err.error) {
          console.log(e.defaultMessage);
          switch (e.field) {
            case 'name':
              this.employeeForm.controls.name.setErrors({'errName': true});
              break;
            case 'email':
              this.employeeForm.controls.email.setErrors({'emailExists': true});
              break;
            case 'idCard':
              switch (e.defaultMessage) {
                case 'invalidIdCard':
                  this.employeeForm.controls.idCard.setErrors({'invalidIdCard': true});
                  break;
                case 'idCardExists':
                  this.employeeForm.controls.idCard.setErrors({'idCardExists': true});
                  break;
              }
              break;
            case 'birthday':
              this.employeeForm.controls.birthday.setErrors({'age18': true});
              break;
          }
        }
      });
    } else {
      this.toastrService.warning('Enter value please!', 'Alert');
    }
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(value => {
      this.getAllEmployee(this.pageNumber, '');
      // @ts-ignore
      $('#staticBackdropDelete' + id).modal('hide');
      this.toastrService.success('Success!', 'Delete');
    });
  }

  nextPage() {
    if (this.pageNumber < this.totalPages.length - 1) {
      this.pageNumber++;
    }
    this.getAllEmployee(this.pageNumber, this.searchForm.value.name);
  }

  previousPage() {
    if (this.pageNumber > 0) {
      this.pageNumber--;
    }
    this.getAllEmployee(this.pageNumber, this.searchForm.value.name);
  }

  changePage(index: number) {
    this.pageNumber = index;
    this.getAllEmployee(index, this.searchForm.value.name);
  }

  searchByName() {
    this.getAllEmployee(0, this.searchForm.value.name);
    console.log(this.pageNumber);
    console.log(this.totalPages.length);
  }
}

import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../service/employee/employee.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {Employee} from '../../model/employee/employee';
import {Division} from '../../model/employee/division';
import {EmployeePosition} from '../../model/employee/employeePosition';
import {EducationDegree} from '../../model/employee/educationDegree';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  employeeForm: FormGroup;
  employee: Employee = {};
  divisions: Division[] = [];
  positions: EmployeePosition[] = [];
  educationDegrees: EducationDegree[] = [];

  constructor(private employeeService: EmployeeService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllDivision();
    this.getAllPosition();
    this.getAllEducationDegree();

    this.employeeForm = new FormGroup({
      id: new FormControl(''),
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
    })
    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      const idEdit = param.get('idEdit');
      this.employeeService.findById(idEdit).subscribe((emp: Employee) => {
        this.employee = emp;
      }, error => {}
      , () => {
          this.createEmployeeForm(this.employee);
        });
    })
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

  createEmployeeForm(employee: Employee) {
    this.employeeForm = new FormGroup({
      id: new FormControl(employee.id),
      name: new FormControl(employee.name, [Validators.required]),
      birthday: new FormControl(employee.birthday, [Validators.required]),
      address: new FormControl(employee.address, [Validators.required]),
      idCard: new FormControl(employee.idCard, [Validators.required]),
      phoneNumber: new FormControl(employee.phoneNumber, [Validators.required]),
      email: new FormControl(employee.email, [Validators.required]),
      salary: new FormControl(employee.salary, [Validators.required]),
      educationDegree: new FormControl(employee.educationDegree, [Validators.required]),
      division: new FormControl(employee.division, [Validators.required]),
      position: new FormControl(employee.position, [Validators.required])
    })
  }

  editEmployee() {
    let employee: Employee = this.employeeForm.value;
    employee.id = +employee.id;
    if (this.employeeForm.valid) {
      this.employeeService.updateEmployee(employee).subscribe(value => {
        this.router.navigateByUrl("/employee-list").then(() => {
          this.toastrService.success("Success!", "Edit");
        })
      }, err => {
        this.toastrService.error('Something wrong!', 'Edit');
        for (const e of err.error) {
          switch (e.field) {
            case 'name':
              this.employeeForm.controls.name.setErrors({'errName': true});
              break;
            case 'email':
              this.employeeForm.controls.email.setErrors({'emailExists': true});
              break;
            case 'idCard':
              switch (e.defaultMessage) {
                case "invalidIdCard":
                  this.employeeForm.controls.idCard.setErrors({'invalidIdCard': true});
                  break;
                case "idCardExists":
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

  compareDivision(d1: Division, d2: Division) {
    if ((d1 && d2) != null) {
      return d1.id === d2.id;
    }
  }

  compareEducationDegree(ed1: EducationDegree, ed2: EducationDegree) {
    if ((ed1 && ed2) != null) {
      return ed1.id === ed2.id;
    }
  }

  comparePosition(p1: EmployeePosition, p2: EmployeePosition) {
    if ((p1 && p2) != null) {
      return p1.id === p2.id;
    }
  }
}

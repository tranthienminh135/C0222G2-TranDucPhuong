import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {User} from '../../model/user';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {AuthService} from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  user: User;

  constructor(private authService: AuthService, private router: Router, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.createLoginForm();
  }

  createLoginForm() {
    this.loginForm = new FormGroup({
      username: new FormControl(),
      password: new FormControl()
    })
  }

  onSubmit() {
    console.log(this.loginForm.value);
    const username: string = this.loginForm.value.username;
    const password: string = this.loginForm.value.password;
    this.authService.isStaff(username, password).subscribe((value) => {
      console.log(value);
      if (value.isAdminRole) {
        this.router.navigateByUrl("/list").then()
      } else if (value.isStaffRole) {
        this.router.navigateByUrl("/list").then()
      }
    })
  }
}

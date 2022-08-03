import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {AuthService} from "../service/auth.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {User} from "../model/user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  jwtTokenUtil: User = {};

  constructor(private authService: AuthService,
              private router: Router,
              private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
    this.loginForm = new FormGroup({
      username: new FormControl(),
      password: new FormControl()
    })
  }

  onSubmit() {
    let username = this.loginForm.value.username;
    let password = this.loginForm.value.password;
    this.jwtTokenUtil = {
      username: username,
      password: password
    }
    this.httpClient.post("http://localhost:8080/authenticate", this.jwtTokenUtil).subscribe(value => {
      console.log(value)
      this.authService.login();
      if (this.authService.isAuthorized) {
        this.router.navigateByUrl("/product/list").then()
      }
    }, error => {
      if (error.status == 401) {
        alert("“Username or Password is incorrect!”.");
      }
    }, () => {});
  }
}

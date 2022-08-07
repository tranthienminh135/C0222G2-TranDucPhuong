import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {LoginService} from "../service/login.service";
import {Router} from "@angular/router";
import {AuthService} from "../service/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(private loginService: LoginService, private router: Router, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.createLoginForm();
  }

  createLoginForm() {
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      remember: new FormControl()
    })
  }

  onLogin() {
    const username = this.loginForm.value.username;
    const password = this.loginForm.value.password;
    const remember = this.loginForm.value.remember;
    this.loginService.login(username, password, remember).subscribe(value => {
      this.authService.isLogin(value);
    }, error => {
      console.log(error)
    }, () => {
      this.router.navigateByUrl("/home").then()
    })
  }
}

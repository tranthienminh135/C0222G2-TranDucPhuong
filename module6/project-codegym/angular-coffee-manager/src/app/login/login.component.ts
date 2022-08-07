import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {LoginService} from "../service/login.service";
import {Router} from "@angular/router";
import {AuthService} from "../service/auth.service";
import {ForgotPasswordService} from "../service/forgot-password.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  forgotPasswordForm: FormGroup;

  constructor(private loginService: LoginService,
              private router: Router,
              private authService: AuthService,
              private forgotPasswordService: ForgotPasswordService,
              private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    if (localStorage.getItem("isRemember") === "On") {
      this.createLoginForm(localStorage.getItem('usernameRemember'), localStorage.getItem('passwordRemember'));
    } else {
      this.createLoginForm('', '');
    }
    this.createForgotPasswordForm();
  }

  createLoginForm(usernameRemember: string, passwordRemember: string) {
    this.loginForm = new FormGroup({
      username: new FormControl(usernameRemember, Validators.required),
      password: new FormControl(passwordRemember, Validators.required),
      remember: new FormControl()
    })
  }
  createForgotPasswordForm() {
    this.forgotPasswordForm = new FormGroup({
      username: new FormControl()
    })
  }

  onLogin() {
    const username = this.loginForm.value.username;
    const password = this.loginForm.value.password;
    const remember = this.loginForm.value.remember;
    if (this.loginForm.valid) {
      this.loginService.login(username, password, remember).subscribe(value => {
        this.authService.isLogin(value);
        if (remember) {
          localStorage.setItem("isRemember", "On");
          localStorage.setItem("usernameRemember", username);
          localStorage.setItem("passwordRemember", password);
        }
        this.toastrService.success("Đăng nhập thành công!")
      }, error => {
        this.toastrService.error("Tên tài khoản hoặc mật khẩu không chính xác!");
      }, () => {
        this.router.navigateByUrl("/home").then()
      })
    } else {
      this.toastrService.error("Thông tin bạn nhập chưa chính xác!")
    }
  }

  onForgotPassword() {
    this.forgotPasswordService.sendMailChangePassword(this.forgotPasswordForm.value).subscribe(value => {
      // @ts-ignore
      $('#staticBackdrop').modal('hide');
      this.toastrService.success("Thành công!");
    }, error => {
      console.log(error)
      this.toastrService.error("Thất bại!")
    }, () => {
      this.router.navigateByUrl("/login").then();
    });
  }
}

import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {ForgotPasswordService} from "../service/forgot-password.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  private forgotPasswordForm: FormGroup;

  constructor(private activatedRoute: ActivatedRoute,
              private forgotPasswordService: ForgotPasswordService,
              private toastrService: ToastrService, private router: Router) {

  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((value) => {
      const token = value.get('token');
      this.createForgotForm(token);
    })
  }

  createForgotForm(token: string) {
    this.forgotPasswordForm = new FormGroup({
      token: new FormControl(token),
      pass: new FormGroup({
        password: new FormControl('', Validators.required),
        confirmPassword: new FormControl('', Validators.required)
      }, this.checkConfirmPassword)
    })
  }
  checkConfirmPassword(pass: AbstractControl) {
    let value = pass.value;
    if (value.password != value.confirmPassword) {
      return {'confirmPass' : true};
    }
    return null;
  }

  onForgot() {
    if (this.forgotPasswordForm.valid) {
      this.forgotPasswordService.changePassword({
        password: this.forgotPasswordForm.value.pass.password,
        token: this.forgotPasswordForm.value.token
      }).subscribe(value => {
        this.forgotPasswordForm.reset();
        this.router.navigateByUrl("/login").then(() => {
          this.toastrService.success("Mật khẩu của bạn đã được thay đổi!");
          // @ts-ignore
          $('#staticBackdrop').modal('hide');
        })
      });
    } else {
      // @ts-ignore
      $('#staticBackdrop').modal('hide');
      this.toastrService.error("Thông tin bạn nhập chưa chính xác!")
    }
  }
}

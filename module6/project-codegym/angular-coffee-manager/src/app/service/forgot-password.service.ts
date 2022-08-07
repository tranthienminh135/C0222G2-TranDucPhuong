import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ForgotPasswordService {
  private SIMPLE_EMAIL_URL = "http://localhost:8080/sendSimpleEmail";
  private CHANGE_PASSWORD_URL = "http://localhost:8080/changePassword";

  constructor(private httpClient: HttpClient) { }

  sendMailChangePassword(value: any): Observable<any> {
    return this.httpClient.post(this.SIMPLE_EMAIL_URL, value);
  }

  changePassword(value: any):Observable<any> {
    return this.httpClient.post(this.CHANGE_PASSWORD_URL, value);
  }
}

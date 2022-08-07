import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private LOGIN_URL = "http://localhost:8080/authenticate";

  constructor(private httpClient: HttpClient) { }

  login(username, password, remember):Observable<any> {
    return this.httpClient.post(this.LOGIN_URL, {username, password});
  }
}

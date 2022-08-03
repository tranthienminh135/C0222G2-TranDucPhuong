import {Injectable} from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public isAuthorized: boolean = false;
  constructor(private router: Router) { }

  login() {
    this.isAuthorized = true;
  }

  logout() {
    this.isAuthorized = false;
  }
}

import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from './auth.service';
import {ToastrService} from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class AuthAdminGuard implements CanActivate {
  constructor(private authService: AuthService , private router: Router, private toastrService: ToastrService) {
  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.authService.isAdminRole) {
      return true;
    } else {
      if (localStorage.getItem("token") != null) {
        if (!this.authService.isAdminRole) {
          this.toastrService.error("You don't have permission!")
        }
      } else {
        this.router.navigateByUrl("/login").then()
      }
      return false;
    }
  }

}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../../model/user';
import {IsRole} from '../../model/isRole';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/authenticate';
  public isStaffRole: boolean = false;
  public isAdminRole: boolean = false;

  constructor(private httpClient: HttpClient) {
  }

  isStaff(username: string, password: string): Observable<IsRole> {
    let user: User = {
      username: username,
      password: password
    };
    let isRole: IsRole = {
      isStaffRole: false,
      isAdminRole: false
    }
    return new Observable<IsRole>(subscriber => {
      this.httpClient.post(this.baseUrl, user).subscribe(value => {
        // @ts-ignore
        localStorage.setItem("token", value.token);
        // @ts-ignore
        isRole.isAdminRole = value.grantList.some(value => {
          return value == 'ROLE_ADMIN';
        });
        // @ts-ignore
        isRole.isStaffRole = value.grantList.some(value => {
          return value == 'ROLE_STAFF';
        });
        subscriber.next(isRole);
      }, error => {}, () => {
        this.isStaffRole = isRole.isStaffRole;
        this.isAdminRole = isRole.isAdminRole;
      });
    });
  }
}

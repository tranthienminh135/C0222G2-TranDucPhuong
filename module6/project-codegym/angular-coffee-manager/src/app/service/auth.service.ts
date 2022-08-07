import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() {
  }

  isLogin(value: any) {
    console.log(value.grantList)
    if (this.isAdmin(value.grantList)){
      localStorage.setItem('role', 'ROLE_ADMIN');
    } else if (this.isStaff(value.grantList)) {
      localStorage.setItem('role', 'ROLE_STAFF');
    } else {
      localStorage.setItem('role', 'ROLE_USER');
    }
    localStorage.setItem('status', 'isLogin');
    localStorage.setItem('username', value.username);
    localStorage.setItem('token', value.token);
  }

  isAdmin(grantList: string[]): boolean {
    return grantList.some(value => {
      return value === 'ROLE_ADMIN';
    })
  }
  isStaff(grantList: string[]): boolean {
    return grantList.some(value => {
      return value === 'ROLE_STAFF';
    })
  }
}

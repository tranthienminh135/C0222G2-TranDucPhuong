import { Component, OnInit } from '@angular/core';
import {UserService} from '../furama-management/service/user/userService';
import {User} from '../furama-management/model/user';

@Component({
  selector: 'app-app-user',
  templateUrl: './app-user.component.html',
  styleUrls: ['./app-user.component.css']
})
export class AppUserComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService) {
    this.userService.getData().subscribe(data => {
      let listData:any = data;
      for (const e of listData) {
        this.users.push(e)
      }
    })
  }

  ngOnInit(): void {
  }

}

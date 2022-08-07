import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  role: string;
  status: string;
  username: string;
  token: string;
  constructor(private router: Router, private toastrService: ToastrService) {
    this.role = this.readLocalStorageValue('role');
    this.status = this.readLocalStorageValue('status');
    this.username = this.readLocalStorageValue('username');
    this.token = this.readLocalStorageValue('token');
  }

  ngOnInit(): void {
  }

  readLocalStorageValue(key: string): string {
    return localStorage.getItem(key);
  }

  onLogout() {
    localStorage.clear();
  }
}

import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private title: Title,
              private toastrService: ToastrService) {
    this.title.setTitle("Trang chủ")
  }

  ngOnInit(): void {
  }

  onAlert() {
    this.toastrService.warning("Tính năng đang trong giai đoạn phát triển!")
  }
}

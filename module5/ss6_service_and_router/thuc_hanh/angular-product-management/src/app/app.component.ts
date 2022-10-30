import { Component } from '@angular/core';
import {CookieService} from "angular2-cookie/core";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-product-management';
  constructor(private cookieService: CookieService) {
    cookieService.put("a", "a");
    console.log(cookieService.get("a"))
    cookieService.removeAll()
  }

}

import { Component } from '@angular/core';
import {CookieService} from "angular2-cookie/core";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-playlist-app';
  constructor(private cookieService: CookieService) {
    cookieService.put("a", "a");
  }
}

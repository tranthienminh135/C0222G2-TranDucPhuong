import {Component} from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private title: Title) {
    this.title.setTitle("The Coffee House");
  }

  onActivate(event) {
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth'
    });
  }
}

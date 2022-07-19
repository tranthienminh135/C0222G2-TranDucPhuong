import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-angular-color-picker-app',
  templateUrl: './angular-color-picker-app.component.html',
  styleUrls: ['./angular-color-picker-app.component.css']
})
export class AngularColorPickerAppComponent implements OnInit {
 color1 = 0;
 color2 = 0;
 color3 = 0;
 setColor1(color1) {
   this.color1 = color1;
 }
  setColor2(color2) {
    this.color2 = color2;
  }
  setColor3(color3) {
    this.color3 = color3;
  }
  constructor() { }

  ngOnInit(): void {
  }

}

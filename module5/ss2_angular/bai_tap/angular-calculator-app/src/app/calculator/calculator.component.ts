import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  firstNumber = 0;
  secondNumber = 0;
  result = 0;

  caculator(ope) {
    if (ope === '+') {
      this.result = Number(this.firstNumber) + Number(this.secondNumber);
    } else if (ope === '-') {
      this.result = Number(this.firstNumber) - Number(this.secondNumber);
    } else if (ope === '*') {
      this.result = Number(this.firstNumber) * Number(this.secondNumber);
    } else {
      this.result = Number(this.firstNumber) / Number(this.secondNumber);
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}

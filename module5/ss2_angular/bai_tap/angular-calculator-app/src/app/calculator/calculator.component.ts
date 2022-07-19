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
  error = '';

  caculator(ope) {
    if (ope === '+') {
      this.result = Number(this.firstNumber) + Number(this.secondNumber);
    } else if (ope === '-') {
      this.result = Number(this.firstNumber) - Number(this.secondNumber);
    } else if (ope === '*') {
      this.result = Number(this.firstNumber) * Number(this.secondNumber);
    } else {
      if (this.secondNumber === 0) {
        this.error = 'Trường hợp phép chia cho 0 vẫn để thực thi à em ?';
      } else {
        this.result = Number(this.firstNumber) / Number(this.secondNumber);
        this.error = '';
      }
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}

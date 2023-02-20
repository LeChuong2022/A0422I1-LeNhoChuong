import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  result: number;


  constructor() {
  }

  ngOnInit(): void {
  }

  calculation(input1: string, input2: string, cal: string) {
    if (cal == 'plus')
      this.result = parseInt(input1) + parseInt(input2);
    else if (cal == 'sub')
      this.result = parseInt(input1) - parseInt(input2);
    else if (cal == 'mul')
      this.result = parseInt(input1) * parseInt(input2);
    else
      this.result = parseInt(input1) / parseInt(input2);
  }

}

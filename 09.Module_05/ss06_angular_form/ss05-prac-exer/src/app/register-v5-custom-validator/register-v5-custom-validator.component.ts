import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {gte} from "src/app/gte.validator.js";

@Component({
  selector: 'app-register-v5-custom-validator',
  templateUrl: './register-v5-custom-validator.component.html',
  styleUrls: ['./register-v5-custom-validator.component.css']
})
export class RegisterV5CustomValidatorComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  myForm = new FormGroup({
      numVal: new FormControl('', [gte])
    }
  );

  get numVal() {
    return this.myForm.get('numVal')
  }

  onSubmit() {
    console.log(this.myForm.value)
  }
}

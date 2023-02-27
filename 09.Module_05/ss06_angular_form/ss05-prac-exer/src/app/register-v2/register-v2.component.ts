import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-register-v2',
  templateUrl: './register-v2.component.html',
  styleUrls: ['./register-v2.component.css']
})
export class RegisterV2Component implements OnInit {

  register = {
    email: 'lenhochuong@gmail.com',
    inputPassword: '123456',
    confirmInputPassword: '123456',
    country: 'Viet Nam',
    age: '33',
    gender: 'male',
    phone: '0987654321'
  };

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(registerFormV2: NgForm) {
    console.log(registerFormV2.value);
  }
}

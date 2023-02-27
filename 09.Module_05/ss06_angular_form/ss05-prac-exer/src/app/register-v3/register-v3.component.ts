import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-register-v3',
  templateUrl: './register-v3.component.html',
  styleUrls: ['./register-v3.component.css']
})
export class RegisterV3Component implements OnInit {

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

  onSubmit(registerFormV3: NgForm) {
    // console.log(registerFormV3.value);
    console.log(this.register);
  }

}

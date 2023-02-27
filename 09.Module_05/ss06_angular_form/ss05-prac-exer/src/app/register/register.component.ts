import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  // register: FormGroup;

  constructor() {
    // this.register = new FormGroup({
    //   email: new FormControl('', [Validators.email]),
    //   inputPassword: new FormControl('', [Validators.minLength(6)]),
    //   confirmInputPassword: new FormControl('', [Validators.minLength(6)]),
    //   country: new FormControl('', [Validators.required]),
    //   age: new FormControl('', [Validators.min(18)]),
    //   gender: new FormControl('', [Validators.required]),
    //   phone: new FormControl('', [Validators.pattern("\\(84\\)[\\d]{9,10}")])
    // }, [this.comparePassword]);
  }

  register = new FormGroup({
    email: new FormControl('', [Validators.email]),
    inputPassword: new FormControl('', [Validators.minLength(6)]),
    confirmInputPassword: new FormControl('', [Validators.minLength(6)]),
    country: new FormControl('', [Validators.required]),
    age: new FormControl('', [Validators.min(18)]),
    gender: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.pattern("\\(84\\)[\\d]{9,10}")])
  }, [this.comparePassword]);

  ngOnInit(): void {
  }

  comparePassword(form: any) {
    let password = form.controls.inputPassword.value;
    let confirmPassword = form.controls.confirmInputPassword.value;
    if (password === confirmPassword) {
      return null;
    }
    return {'passwordNotMatch': true};
  }


  onSubmit() {
    console.log(this.register.value);
  }
}

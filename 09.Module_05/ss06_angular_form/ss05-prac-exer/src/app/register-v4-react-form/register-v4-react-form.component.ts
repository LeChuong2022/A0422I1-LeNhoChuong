import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register-v4-react-form',
  templateUrl: './register-v4-react-form.component.html',
  styleUrls: ['./register-v4-react-form.component.css']
})
export class RegisterV4ReactFormComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  countryList = [
    {id: 1, name: 'Viet Name'},
    {id: 2, name: 'Canada'},
    {id: 3, name: 'USA'},
  ];
  contactForm = new FormGroup({
    // email: new FormControl(),
    // inputPassword: new FormControl(),
    // confirmInputPassword: new FormControl(),
    // country: new FormControl(),
    // age: new FormControl(),
    // gender: new FormControl(),
    // phone: new FormControl()
    firstname: new FormControl('', [Validators.required, Validators.minLength(10)]),
    lastname: new FormControl('', [Validators.maxLength(15), Validators.pattern("^[a-zA-Z]+$")]),
    email: new FormControl('', [Validators.email, Validators.required]),
    gender: new FormControl('', [Validators.required]),
    isMarried: new FormControl('', [Validators.required]),
    country: new FormControl('', [Validators.required]),
    address: new FormGroup({
      city: new FormControl('', [Validators.required]),
      street: new FormControl('', [Validators.required]),
      pincode: new FormControl('', [Validators.required])
    })
  });

  get firstname(){
    return this.contactForm.get('firstname');
  }

  onSubmit() {
    console.log(this.contactForm.value)
  }
}

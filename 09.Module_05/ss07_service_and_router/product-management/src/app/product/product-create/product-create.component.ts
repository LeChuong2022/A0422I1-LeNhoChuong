import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  rfProduct: FormGroup;

  constructor(
    private _formBuilder: FormBuilder,
    private _router: Router,
    private _productService: ProductService
  ) {
  }

  ngOnInit(): void {
    this.rfProduct = this._formBuilder.group({
      id:[],
      name: ['', [Validators.required, Validators.minLength(5)]],
      price: [],
      description: []
    })
  }

  onSubmit() {
    if (this.rfProduct.valid) {
      this._productService.save(this.rfProduct.value);
      this._router.navigateByUrl("/home");
      console.log(this.rfProduct.value);

    }
  }
}

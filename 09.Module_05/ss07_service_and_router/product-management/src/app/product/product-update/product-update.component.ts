import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  rfProduct: FormGroup;
  id: number;
  product: Product | undefined;

  constructor(
    private _formBuilder: FormBuilder,
    private _router: Router,
    private _productService: ProductService,
    private  _activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    const productId = parseInt(this._activatedRoute.snapshot.params['id']);
    this.product = this._productService.findById(productId);
    console.log("gia tri " + this.product);


    this.rfProduct = this._formBuilder.group({
      id: [this.product.id],
      name: [this.product.name, [Validators.required, Validators.minLength(5)]],
      price: [this.product.price],
      description: [this.product.description]
    })
  }

  onSubmit() {
    if (this.rfProduct.valid) {
      const product = this.rfProduct.value;
      // this._productService.update(id, product);
      this._productService.update(product);
      this._router.navigateByUrl("/home");
    }
  }

}

import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  productDetail: Product | undefined;


  constructor(
    private _router: Router,
    private _productService: ProductService,
    private  _activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    const productId = parseInt(this._activatedRoute.snapshot.params['id']);
    this.productDetail = this._productService.findById(productId);
    // this.product = this._productService.findById(productId);

    // this._productService.delete(productId)
  }

  delete(id: number) {
    this._productService.delete(id);
    this._router.navigateByUrl("/home");

  }
}

import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  product: Product | undefined;
  products: Product[] | undefined;

  constructor(private _productService: ProductService) {
  }

  ngOnInit(): void {
    this.products = this._productService.getAllProduct();
  }

  showDetail(s: any) {

  }
}

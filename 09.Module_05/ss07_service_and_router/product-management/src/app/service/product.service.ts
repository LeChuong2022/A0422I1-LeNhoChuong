import {Injectable} from '@angular/core';
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private _products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];

  constructor() {
  }

  getAllProduct(): Product[] {
    console.log("gia tri products o service lam list: " + this._products);

    return this._products;
  }

  save(product: Product) {
    this._products.push(product);
    console.log(product)
  }

  getProductByIndex(index: number) {
    return this._products[index];
  }

  findById(id: number) {
    return this._products.find(product => product.id === id);
  }

  update(product: Product) {
    for (let i = 0; i < this._products.length; i++) {
      if (this._products[i].id === product.id) {
        this._products[i] = product;
      }
    }
  }

  delete(id: number) {
    this._products = this._products.filter(product => {
      return product.id !== id;
    });
  }
}

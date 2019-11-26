import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Product} from "../categories/products/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http : HttpClient) { }

  getProductsByIdCategory(idCategory: string): Observable<Product[]>{
    return this.http.get<Product[]>('/api/product/category/' + idCategory)
  }

}

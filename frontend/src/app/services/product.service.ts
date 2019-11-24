import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Product} from "../categories/products/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http : HttpClient) { }

  getProducts(): Observable<Product[]>{
    return this.http.get<Product[]>('/api/product')
  }

  getProductById(id: string): Observable<Product> {
    return this.http.get<Product>('/api/product/' + id);
  }
}

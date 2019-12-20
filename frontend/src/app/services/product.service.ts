import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Product} from "../modules/product";
import {OrgRegistration} from "../modules/orgRegistration";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http : HttpClient) { }

  getProductsByIdCategory(idCategory: string): Observable<Product[]>{
    return this.http.get<Product[]>('/api/product/category/' + idCategory)
  }

  getProductsByIdOrganisation(idOrganisation: number): Observable<Product[]>{
    return this.http.get<Product[]>('/api/product/organisation/' + idOrganisation)
  }

  createProd(information: Product): Observable<Product> {
    return this.http.post<Product>('/api/product', information);
  }

}

import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Product} from "../modules/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http : HttpClient) { }

  getProductsByIdCategory(idCategory: string): Observable<Product[]>{
    return this.http.get<Product[]>('/api/product/category/' + idCategory)
  }

  getProductsByIdOrganisation(idOrganisation: string): Observable<Product[]>{
    return this.http.get<Product[]>('/api/product/organisation/' + idOrganisation)
  }

}

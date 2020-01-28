import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Product} from "../modules/product";
import {OrgRegistration} from "../modules/orgRegistration";
import {Page} from "../modules/page";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http : HttpClient) { }

  getProductsByIdCategory(idCategory: string, pageNum: number, pageSize: number): Observable<Page>{
    return this.http.get<Page>('/api/product/category/' + idCategory + '?offset='+ pageNum +'&limit=' + pageSize)
  }

  getProductsByIdOrganisation(idOrganisation: number, pageNum: number, pageSize: number): Observable<Page>{
    return this.http.get<Page>('/api/product/organisation/' + idOrganisation + '?offset='+ pageNum +'&limit=' + pageSize)
  }

  createProd(information: Product): Observable<Product> {
    return this.http.post<Product>('/api/product', information);
  }

  deleteProduct(idProd: string): Observable<void>{
    return this.http.delete<void>('api/product/delete/' + idProd);
  }

}

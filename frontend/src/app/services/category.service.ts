import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Category} from "../nav/categories/category";
import {HttpClient} from "@angular/common/http";

 @Injectable({
 providedIn: 'root'
})
export class CategoryService {

  constructor(private http : HttpClient) { }

  getCategories(): Observable<Category[]>{
    return this.http.get<Category[]>('/api/category')
  }
}

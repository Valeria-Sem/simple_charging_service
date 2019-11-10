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
//    console.log("sdfsadgd")
    return this.http.get<Category[]>('http://localhost:8081/api/category')
  }
}

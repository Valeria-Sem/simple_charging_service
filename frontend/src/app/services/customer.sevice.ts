import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Customer} from "../registration/customer";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

 // private subjectUser: Subject<Customer> = new Subject();

  constructor(private http: HttpClient) {
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>('/api/customer', customer);
  }

 // getCustomerById()

}

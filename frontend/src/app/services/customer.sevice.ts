import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Customer} from "../registration/customer";
import {tap} from "rxjs/operators";
import {User} from "../nav/user/user";

@Injectable({
  providedIn: "root"
})
export class CustomerService {
  public currentCustomer: Customer;

  private subjectCustomer: Subject<Customer> = new Subject();

  public currentCustomer$ = this.subjectCustomer.asObservable();

  constructor(private http: HttpClient) {
  }

  getCustomerProfileInfo(login: string, password: string): Observable<Customer> {
    return this.http.get<Customer>('/api/registration/login/' + login + '/password/' + password).pipe(
      tap(customer => {
        this.subjectCustomer.next(customer);
        this.currentCustomer = customer;
      })
    );
  }

  public setCustomer(customer: Customer): void {
    this.subjectCustomer.next(customer);
  }

}

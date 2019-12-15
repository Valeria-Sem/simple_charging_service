import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Customer} from "../registration/customer";
import {tap} from "rxjs/operators";
import {User} from "../nav/user/user";
import {Registration} from "../registration/registration";

@Injectable({
  providedIn: "root"
})
export class CustomerService {
  public currentCustomer: Registration;

  private subjectCustomer: Subject<Registration> = new Subject();

  public currentCustomer$ = this.subjectCustomer.asObservable();

  constructor(private http: HttpClient) {
  }

  getCustomerProfileInfo(login: string, password: string): Observable<Registration> {
    return this.http.get<Registration>('/api/registration/login/' + login + '/password/' + password).pipe(
      tap(customer => {
        this.subjectCustomer.next(customer);
        this.currentCustomer = customer;
      })
    );
  }

  public setCustomer(customer: Registration): void {
    this.subjectCustomer.next(customer);
  }

}

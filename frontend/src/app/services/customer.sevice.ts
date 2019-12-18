import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Customer} from "../modules/customer";
import {tap} from "rxjs/operators";
import {User} from "../modules/user";
import {CusRegistration} from "../modules/cusRegistration";

@Injectable({
  providedIn: "root"
})
export class CustomerService {
  public currentCustomer: CusRegistration;

  private subjectCustomer: Subject<CusRegistration> = new Subject();

  public currentCustomer$ = this.subjectCustomer.asObservable();

  constructor(private http: HttpClient) {
  }
// todo поменять порт на 8081
  getCustomerProfileInfo(login: string, password: string): Observable<CusRegistration> {
    return this.http.get<CusRegistration>('/api/registration/login/' + login + '/password/' + password).pipe(
      tap(customer => {
        this.subjectCustomer.next(customer);
        this.currentCustomer = customer;
      })
    );
  }

  public setCustomer(customer: CusRegistration): void {
    this.subjectCustomer.next(customer);
  }

}

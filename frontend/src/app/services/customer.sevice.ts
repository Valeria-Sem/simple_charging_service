import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Customer} from "../modules/customer";
import {tap} from "rxjs/operators";
import {User} from "../modules/user";
import {CusRegistration} from "../modules/cusRegistration";
import {UserInf} from "../modules/userInf";

@Injectable()
export class CustomerService {
  public currentCustomer: CusRegistration;

  private subjectCustomer: Subject<CusRegistration> = new Subject();

  public currentCustomer$ = this.subjectCustomer.asObservable();

  constructor(private http: HttpClient) {
  }

  getCustomerProfileInfo(login: string, password: string): Observable<CusRegistration> {
    return this.http.get<CusRegistration>('/api/registration/login/' + login + '/password/' + password).pipe(
      tap(customer => {
        this.subjectCustomer.next(customer);
        this.currentCustomer = customer;
        localStorage.setItem("user", JSON.stringify(customer));
      })
    );
  }

  public setCustomer(customer: CusRegistration): void {
    this.subjectCustomer.next(customer);
  }

  saveCust(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>('/api/customer', customer);
  }
}

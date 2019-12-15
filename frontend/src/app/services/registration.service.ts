import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Registration} from "../registration/registration";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) {
  }

  saveCustomer(information: Registration): Observable<Registration> {
    return this.http.post<Registration>('/api/registration/customer', information);
  }

}

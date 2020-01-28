import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {CusRegistration} from "../modules/cusRegistration";
import {tap} from "rxjs/operators";
import {OrgRegistration} from "../modules/orgRegistration";

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) {
  }

  saveCustomer(information: CusRegistration): Observable<CusRegistration> {
    return this.http.post<CusRegistration>('/api/registration/customer', information);
  }

  saveOrganisation(information: OrgRegistration): Observable<OrgRegistration> {
    return this.http.post<OrgRegistration>('/api/registration/organisation', information);
  }

}

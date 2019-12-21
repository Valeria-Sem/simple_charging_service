import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Subscription} from "../modules/subscription";
import {CustProd} from "../modules/CustProd";

@Injectable({
  providedIn: 'root'
})
export class SubService {

  constructor(private http: HttpClient) {
  }

  subscribeCustomer(information: Subscription, idCust: string, idProd: string): Observable<Subscription> {
    return this.http.post<Subscription>('/api/subscription/cust/' + idCust +'/prod/' + idProd, information);
  }

  getSub(idCust: string): Observable<CustProd[]> {
    return this.http.get<CustProd[]>('/api/customerSub/customer/' + idCust);
  }

  unsubscribe(idSub: string): Observable<void> {
    return this.http.delete<void>('/api/subscription/delete/' + idSub);
  }
}

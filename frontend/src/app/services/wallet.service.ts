import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Wallet} from "../registration/wallet";
import {tap} from "rxjs/operators";
import {User} from "../nav/user/user";

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  private subjectUser: Subject<Wallet> = new Subject();

  public currentWallet$ = this.subjectUser.asObservable();

  constructor(private http: HttpClient) {
  }
  getWalletById(idWallet: Wallet): Observable<Wallet>{
    return this.http.get<Wallet>('/api/wallet/' + idWallet).pipe(
      tap(wallet => this.subjectUser.next(wallet))
    );
  }

  balanceReplenishment(information: Wallet): Observable<Wallet> {
    return this.http.post<Wallet>('/api/wallet/replenishment', information);
  }

  payment(information: Wallet): Observable<Wallet> {
    return this.http.post<Wallet>('/api/wallet/payment', information);
  }
}

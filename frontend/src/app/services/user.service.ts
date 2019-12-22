import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, ReplaySubject, Subject} from "rxjs";
import {User} from "../modules/user";
import {tap} from "rxjs/operators";
import {UserInf} from "../modules/userInf";

@Injectable()
export class UserService {

  public currentUser: User;

  public currentUser$: ReplaySubject<User> = new ReplaySubject(1);

  constructor(private http: HttpClient) {
  }

  getUserInfo(login: string, password: string): Observable<User> {
    return this.http.get<User>('/api/registration/login/' + login + '/password/' + password).pipe(
      tap(user => {
        this.currentUser$.next(user);
        this.currentUser = user;
        localStorage.setItem("user", JSON.stringify(user));
      })
    );
  }

  public setUser(user: User): void {
    this.currentUser$.next(user);
    this.currentUser = user;
  }

  deleteUser(idUser: number, idWallet: string): Observable<void> {
    return this.http.delete<void>('/api/registration/user/delete/' + idUser + "/" + idWallet)
  }

  saveUser(user: UserInf): Observable<UserInf> {
    return this.http.post<UserInf>('/api/user', user);
  }
}

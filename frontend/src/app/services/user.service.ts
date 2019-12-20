import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, ReplaySubject, Subject} from "rxjs";
import {User} from "../modules/user";
import {tap} from "rxjs/operators";

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
}

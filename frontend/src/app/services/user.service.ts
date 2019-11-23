import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {User} from "../nav/user/user";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // public currentUser: User = null;

  private subjectUser: Subject<User> = new Subject();

  public currentUser$ = this.subjectUser.asObservable();

  constructor(private http: HttpClient) {
  }

  // saveUser(user: User): Observable<User> {
  //   return this.http.post<User>('/api/user', user);
  // }

  getUserByLogin(login: string): Observable<User> {
    return this.http.get<User>('/api/user/login/' + login).pipe(
      tap(user => this.subjectUser.next(user))
    );
  }

  // getAllUsers(): Observable<User[]> {
  //   return this.http.get<User[]>('api/user');
  // }
  //
  // deleteUser(id: string): Observable<void> {
  //   return this.http.delete<void>('/api/user/' + id);
  // }
}

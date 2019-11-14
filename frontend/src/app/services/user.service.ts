import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../nav/user/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public currentUser: User = null;

  constructor(private http: HttpClient) {
  }

  // saveUser(user: User): Observable<User> {
  //   return this.http.post<User>('/api/user', user);
  // }

  getUserByLogin(login: string): Observable<User> {
    return this.http.get<User>('/api/user/login/' + login);
  }

  // getAllUsers(): Observable<User[]> {
  //   return this.http.get<User[]>('api/user');
  // }
  //
  // deleteUser(id: string): Observable<void> {
  //   return this.http.delete<void>('/api/user/' + id);
  // }
}

import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {UserService} from "./user.service";

@Injectable()
export class RoleGuard implements CanActivate {


  constructor(private userService: UserService, private _router: Router) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (this.userService.currentUser && this.userService.currentUser.role === next.data.role) {
      return true;
    }

    // navigate to not found page
    this._router.navigate(['/']);
    return false;
  }

}

import { Component } from "@angular/core";
import {Role, User} from "../../nav/user/user";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";

@Component({
  selector: "app-orgReg",
  templateUrl: "./org.registration.component.html",
  styleUrls: ['./org.registration.component.css']
})
export class OrganisationRegComponent {
  user: User;
  public login: string;
  public password: string;
  public role: Role = Role.ORGANISATION;

  constructor(private router: Router,
              private userSevice : UserService) {
  }

  ngOnInit(){
  }

  public saveUser(user): void {
    this.user = new User(this.login, this.password, this.role);
    //   .login = this.login;
    // this.user.password = this.password;
    // this.user.role = this.role;
    this.userSevice.saveUser(this.user).subscribe();
  }
}

import {Component} from "@angular/core";
import {Role, User} from "../../nav/user/user";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: "app-useReg",
  templateUrl: "./user.registration.component.html",
  styleUrls: ['./user.registration.component.css']
})
export class UserRegComponent {
  user: User;
  public login: string;
  public password: string;
  public role: Role = Role.CUSTOMER;

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

import {Component, OnInit} from "@angular/core";
import {Role, User} from "../../../modules/user";
import {CusRegistration} from "../../../modules/cusRegistration";
import {Status} from "../../../modules/wallet";
import {RegistrationService} from "../../../services/registration.service";
import {UserService} from "../../../services/user.service";
import {UserInf} from "../../../modules/userInf";
import {Customer} from "../../../modules/customer";

@Component({
  selector: "app-custInfo",
  templateUrl: "./custInfo.component.html",
  styleUrls: ['./custInfo.component.css']
})
export class CustInfoComponent implements OnInit{

  custInfo: Customer;
  userInfo: UserInf;
  public login: string;
  public password: string;
  public name: string;
  public surname: string;
  public eMail: string;
  public balance: number = 100;
  public walletStatus: Status = 0;
  public role: Role = Role.CUSTOMER;
  public user: User = this.userService.currentUser;

  constructor(private registrationService:RegistrationService,
              private userService: UserService) {
  }

  ngOnInit(){
  }

  public saveCustInfo(userInfo, custInfo): void {
    this.userInfo = new UserInf(this.login, this.password);
    this.userService.saveUser(this.userInfo).subscribe();

    this.custInfo = new Customer(this.name, this.surname, this.eMail)
  }
}

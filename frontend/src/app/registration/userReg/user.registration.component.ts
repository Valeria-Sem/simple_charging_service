import {Component} from "@angular/core";
import {Role} from "../../nav/user/user";
import {Registration} from "../registration";
import {Status} from "../wallet";
import {RegistrationService} from "../../services/registration.service";

@Component({
  selector: "app-useReg",
  templateUrl: "./user.registration.component.html",
  styleUrls: ['./user.registration.component.css']
})
export class UserRegComponent {
  // user: User;
  // customer: Customer;
  information: Registration;
  public login: string;
  public password: string;
  public name: string;
  public surname: string;
  public eMail: string;
  public balance: string = "100";
  public walletStatus: Status = 0;
  public role: Role = Role.CUSTOMER;

  constructor(private registrationService:RegistrationService) {
  }

  ngOnInit(){
  }

  public saveAll(information): void {
    this.information = new Registration(this.name, this.surname, this.eMail, this.balance,
      this.walletStatus, this.login, this.password, this.role);
    this.registrationService.saveAll(this.information).subscribe();
  }
}

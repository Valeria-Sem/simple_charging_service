import {Component, OnInit} from "@angular/core";
import {Role} from "../../../modules/user";
import {CusRegistration} from "../../../modules/cusRegistration";
import {Status} from "../../../modules/wallet";
import {RegistrationService} from "../../../services/registration.service";

@Component({
  selector: "app-useReg",
  templateUrl: "./customer.registration.component.html",
  styleUrls: ['./customer.registration.component.css']
})
export class UserRegComponent implements OnInit{

  information: CusRegistration;
  public login: string;
  public password: string;
  public name: string;
  public surname: string;
  public eMail: string;
  public balance: number = 100;
  public walletStatus: Status = 0;
  public role: Role = Role.CUSTOMER;

  constructor(private registrationService:RegistrationService) {
  }

  ngOnInit(){
  }

  public saveCustomer(information): void {
    this.information = new CusRegistration(this.name, this.surname, this.eMail, this.balance,
      this.walletStatus, this.login, this.password, this.role);
    this.registrationService.saveCustomer(this.information).subscribe();
  }
}

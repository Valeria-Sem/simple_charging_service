import {Component} from "@angular/core";
import {Status} from "../../registration/wallet";
import {CustomerService} from "../../services/customer.sevice";

@Component({
  selector: "app-useReg",
  templateUrl: "./user.registration.component.html",
  styleUrls: ['./user.registration.component.css']
})
export class CustomerProfileComponent {
  // user: User;
  // customer: Customer;
  //information: Registration;
  public name: string;
  public surname: string;
  public eMail: string;
  public balance: string = "100";
  public walletStatus: Status = 0;

  constructor(customerService: CustomerService) {
  }

  ngOnInit(){
  }

  // public saveAll(information): void {
  //   this.information = new Registration(this.name, this.surname, this.eMail, this.balance,
  //     this.walletStatus, this.login, this.password, this.role);
  //   this.registrationService.saveAll(this.information).subscribe();
  // }
}

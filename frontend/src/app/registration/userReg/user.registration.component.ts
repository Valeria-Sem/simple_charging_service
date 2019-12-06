import {Component} from "@angular/core";
import {Role} from "../../nav/user/user";
import {Registration} from "../registration";
import {Status} from "../wallet";

@Component({
  selector: "app-useReg",
  templateUrl: "./user.registration.component.html",
  styleUrls: ['./user.registration.component.css']
})
export class UserRegComponent {
  // user: User;
  // customer: Customer;
  //information: Registration;
  public login: string;
  public password: string;
  public name: string;
  public surname: string;
  public email: string;
  public balance: string = "100";
  public walletStatus: Status = 0;
  public role: Role = Role.CUSTOMER;

  constructor() {
  }

  ngOnInit(){
  }

  // public saveUser(user): void {
  //   this.user = new User(this.login, this.password, this.role);
  //   this.userSevice.saveUser(this.user).subscribe();
  // }
  //
  // public saveCustomer(customer): void {
  //   this.customer = new Customer(this.name, this.surname, this.email);
  //   this.customerSevice.saveCustomer(this.customer).subscribe();
  // }

  public saveAll(): void{
    let information = new Registration(this.name, this.surname, this.email, this.balance, this.walletStatus, this.login, this.password, this.role)
    let registration = {
      ...information
    }
    console.log(registration);
  }
}

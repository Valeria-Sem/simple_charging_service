import {Component} from "@angular/core";
import {Role, User} from "../../nav/user/user";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {Customer} from "../customer";
import {CustomerService} from "../../services/customer.sevice";

@Component({
  selector: "app-useReg",
  templateUrl: "./user.registration.component.html",
  styleUrls: ['./user.registration.component.css']
})
export class UserRegComponent {
  user: User;
  customer: Customer;
  public login: string;
  public password: string;
  public name: string;
  public surname: string;
  public email: string;
  public balance: string;
  //public walletStatus: ;
  public role: Role = Role.CUSTOMER;

  constructor(private customerSevice: CustomerService,
              private userSevice : UserService) {
  }

  ngOnInit(){
  }

  public saveUser(user): void {
    this.user = new User(this.login, this.password, this.role);
    this.userSevice.saveUser(this.user).subscribe();
  }

  public saveCustomer(customer): void {
    this.customer = new Customer(this.name, this.surname, this.email);
    this.customerSevice.saveCustomer(this.customer).subscribe();
  }

  public saveAll(): void{
    let user = new User(this.login, this.password, this.role);
    let customer = new Customer(this.name, this.surname, this.email);

    let registration = {
      ...user,
      ...customer
    }

    console.log(registration);
  }
}

import {Role} from "../nav/user/user";
import {Status} from "./wallet";

export class Registration {
  idCustomer: string;
  name: string;
  surname: string;
  email: string;

  idUser: string;
  login: string;
  password: string;
  role: Role;

  idWallet: string;
  balance: string;
  walletStatus: Status;


  constructor(name: string, surname: string, email: string, balance: string, walletStatus: Status, login: string, password: string, role: Role) {
    this.login = login;
    this.password = password;
    this.role = role;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.balance = balance;
    this.walletStatus = walletStatus;
  }
}


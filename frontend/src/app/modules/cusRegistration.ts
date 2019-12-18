import {Role} from "./user";
import {Status} from "./wallet";

export class CusRegistration {
  idCustomer: string;
  name: string;
  surname: string;
  eMail: string;

  idUser: string;
  login: string;
  password: string;
  role: Role;

  idWallet: string;
  balance: number;
  walletStatus: Status;


  constructor(name: string, surname: string, eMail: string, balance: number, walletStatus: Status, login: string, password: string, role: Role) {
    this.login = login;
    this.password = password;
    this.role = role;
    this.name = name;
    this.surname = surname;
    this.eMail = eMail;
    this.balance = balance;
    this.walletStatus = walletStatus;
  }
}


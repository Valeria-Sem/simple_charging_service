import {Status} from "./wallet";

export class User {

  idUser: number;
  login: string;
  password: string;
  role: Role;
  idWallet: string;
  balance: number;
  walletStatus: Status;
  idOrganisation: number;
  name: string;
  eMail: string;
  linkOfSite: string;
  phone: string;
  idCustomer: string;
  surname: string;


  constructor(login: string, password: string, role: Role, balance: number, walletStatus: Status) {
    this.login = login;
    this.password = password;
    this.role = role;
    this.balance = balance;
    this.walletStatus = walletStatus;
  }


}

export enum Role {
  CUSTOMER = "CUSTOMER",
  ORGANISATION = "ORGANISATION"
}


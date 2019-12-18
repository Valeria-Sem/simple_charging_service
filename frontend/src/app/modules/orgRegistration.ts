import {Role} from "./user";
import {Status} from "./wallet";

export class OrgRegistration {
  idOrganisation: string;
  name: string;
  eMail: string;
  linkOfSite: string;
  phone: string;

  idUser: string;
  login: string;
  password: string;
  role: Role;

  idWallet: string;
  balance: number;
  walletStatus: Status;


  constructor(name: string, eMail: string,
              linkOfSite: string, phone: string,
              balance: number, walletStatus: Status,
              login: string, password: string, role: Role) {
    this.login = login;
    this.password = password;
    this.role = role;
    this.name = name;
    this.eMail = eMail;
    this.linkOfSite = linkOfSite;
    this.phone = phone;
    this.balance = balance;
    this.walletStatus = walletStatus;
  }
}


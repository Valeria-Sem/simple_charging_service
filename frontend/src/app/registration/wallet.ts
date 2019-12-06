export class Wallet {
  idWallet: string;
  balance: string;
  walletStatus: Status;


  constructor(balance: string, walletStatus: Status) {
    this.balance = balance;
    this.walletStatus = walletStatus;
  }

}

export enum Status {
  ACTIVE,
  FROZEN,
  BLOCKED
}

export class OrganisationStr{

}

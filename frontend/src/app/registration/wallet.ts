export class Wallet {
  idWallet: string;
  balance: string;
  walletStatus: Status;


  constructor(balance: string) {
    this.balance = balance;
  }

}

export enum Status {
  ACTIVE,
  FROZEN,
  BLOCKED
}

export class OrganisationStr{

}

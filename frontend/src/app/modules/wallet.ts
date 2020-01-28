export class Wallet {
  idWallet: string;
  balance: number;
  walletStatus: Status;


  constructor( idWallet: string, balance: number, walletStatus: Status) {
    this.idWallet = idWallet;
    this.balance = balance;
    this.walletStatus = walletStatus;
  }

}

export enum Status {
  ACTIVE = "ACTIVE",
  FROZEN = "FROZEN",
  BLOCKED = "BLOCKED"
}


export class Subscription {
  idSubscription: string;
  idCustomer: string;
  idProduct: string;
  subscriptionStatus: SubStatus;
  dateOfSubscription: Date;

  constructor(idCustomer: string,
              idProduct: string, subscriptionStatus: SubStatus,
              dateOfSubscription: Date) {
    // this.idSubscription = idSubscription;
    this.idProduct = idProduct;
    this.idCustomer = idCustomer;
    this.subscriptionStatus = subscriptionStatus;
    this.dateOfSubscription = dateOfSubscription;

  }
}

export enum SubStatus {
  ACTIVE,
  FROZEN,
  BLOCKED
}


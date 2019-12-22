import {SubStatus} from "./subscription";

export class CustProd {
  idSubscription: string;
  idCustomer: string;
  idProduct: string;
  name: string;
  description: string;
  monthPrise: number;
  img: string;
  subscriptionStatus: SubStatus;


  constructor(idSubscription: string,
              idCustomer: string, name: string,
              idProduct: string, description: string,
              monthPrise: number, img: string, subscriptionStatus: SubStatus) {
    this.idSubscription = idSubscription;
    this.idProduct = idProduct;
    this.idCustomer = idCustomer;
    this.name = name;
    this.description = description;
    this.monthPrise = monthPrise;
    this.img = img;
    this.subscriptionStatus = subscriptionStatus;

  }
}



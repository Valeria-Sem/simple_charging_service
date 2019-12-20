export class CustProd {
  idSubscription: string;
  idCustomer: string;
  idProduct: string;
  name: string;
  description: string;
  monthPrise: number;
  img: string;


  constructor(idSubscription: string,
              idCustomer: string, name: string,
              idProduct: string, description: string,
              monthPrise: number, img: string) {
    this.idSubscription = idSubscription;
    this.idProduct = idProduct;
    this.idCustomer = idCustomer;
    this.name = name;
    this.description = description;
    this.monthPrise = monthPrise;
    this.img = img;


  }
}



import {Status} from "./wallet";
import {Role} from "./user";

export class Product {
  idProduct: string;
  idCategory: number;
  description: string;
  idOrganisation: number;
  monthPrise: number;
  name: string;
  img: string;


  constructor(idOrganisation: number, name: string,
               description: string,
               monthPrise: number,idCategory: number,
               img: string) {
    this.idCategory = idCategory;
    this.description = description;
    this.idOrganisation = idOrganisation;
    this.name = name;
    this.monthPrise = monthPrise;
    this.img = img;
  }

}


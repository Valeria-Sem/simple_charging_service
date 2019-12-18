export class Product {
  id: string;
  idCategory: string;
  description: string;
  idOrganisation: string;
  monthPrise: string;
  name: string;
  img: string;


  static cloneBase(product: Product): Product{
    const cloneProduct: Product = new Product();
    cloneProduct.id = product.id;
    cloneProduct.name = product.name;
    cloneProduct.idCategory = product.idCategory;
    cloneProduct.description = product.description;
    cloneProduct.idOrganisation = product.idOrganisation;
    cloneProduct.monthPrise = product.monthPrise;
    cloneProduct.img = product.img;
    return cloneProduct;
  }

}

export class ProductStr{

}

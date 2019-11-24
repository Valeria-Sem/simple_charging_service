export class Product {
  id: string;
  id_category: string;
  description: string;
  id_organisation: string;
  month_price: string;
  name: string;


  static cloneBase(product: Product): Product{
    const cloneCategory: Product = new Product();
    cloneCategory.id = product.id;
    cloneCategory.name = product.name;
    cloneCategory.id_category = product.id_category;
    cloneCategory.description = product.description;
    cloneCategory.id_organisation = product.id_organisation;
    cloneCategory.month_price = product.month_price;
    return cloneCategory;
  }
}

export class ProductStr{

}

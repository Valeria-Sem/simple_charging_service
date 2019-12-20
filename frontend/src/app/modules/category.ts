export class Category {
  idCategory: string;
  name: string;

  static cloneBase(category: Category): Category{
  const cloneCategory: Category = new Category();
    cloneCategory.idCategory = category.idCategory;
    cloneCategory.name = category.name;
    return cloneCategory;
  }
}

export class CategoryStr{

}

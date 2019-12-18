export class Category {
  id: string;
  name: string;

  static cloneBase(category: Category): Category{
  const cloneCategory: Category = new Category();
    cloneCategory.id = category.id;
    cloneCategory.name = category.name;
    return cloneCategory;
  }
}

export class CategoryStr{

}

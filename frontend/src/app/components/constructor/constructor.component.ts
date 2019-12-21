import {ChangeDetectorRef, Component, OnInit} from "@angular/core";
import { BsDropdownConfig } from 'ngx-bootstrap/dropdown';
import {OrgRegistration} from "../../modules/orgRegistration";
import {Status} from "../../modules/wallet";
import {Role, User} from "../../modules/user";
import {RegistrationService} from "../../services/registration.service";
import {ProductService} from "../../services/product.service";
import {Product} from "../../modules/product";
import {UserService} from "../../services/user.service";
import {Category} from "../../modules/category";
import {CategoryService} from "../../services/category.service";
import {Page} from "../../modules/page";

@Component({
  selector: "app-cunst",
  templateUrl: "./constructor.component.html",
  styleUrls: ['./constructor.component.css'],
  providers: [{ provide: BsDropdownConfig, useValue: { isAnimated: true, autoClose: true } }]
})
export class ConstructorComponent implements OnInit{
  information: Product;
  public user: User = this.userService.currentUser;
  idCategory: number;
  description: string;
  idOrganisation: string;
  monthPrise: string;
  name: string;
  img: string;
  categories: Category[];
  category: number;
  currentPage: number = 0;
  page: number;
  products: Page;

  constructor(private productService : ProductService,
              private userService: UserService,
              private categoryService: CategoryService,
              private cdr: ChangeDetectorRef) {
  }

  ngOnInit(){
    this.categoryService.getCategories().subscribe((data) => {
      this.categories = data as Category[];
      // this.cdr.detectChanges();
    });
  }

  public getCatId(category){
    this.idCategory = category;
  }

  public createProd(information): void {
    this.information = new Product(this.user.idOrganisation, this.name,
      this.description,  (+this.monthPrise), (+this.idCategory),
      this.img);
    this.productService.createProd(this.information).subscribe();

    this.productService.getProductsByIdOrganisation(this.user.idOrganisation,this.currentPage,6).subscribe((data) => {
      this.products = data as Page;
      this.cdr.detectChanges();
    });


  }
}

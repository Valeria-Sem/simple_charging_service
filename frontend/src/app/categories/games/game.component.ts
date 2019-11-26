import {ChangeDetectorRef, Component} from "@angular/core";
import {Category} from "../../nav/categories/category";
import {CategoryService} from "../../services/category.service";
import {ProductService} from "../../services/product.service";
import {Product} from "../products/product";

@Component({
  selector: "app-games",
  templateUrl: "./game.component.html",
  styleUrls: ['./game.component.css']
})
export class GamesComponent {
  products: Product[];

  constructor(private productService: ProductService,
              private cdr: ChangeDetectorRef,) {}

  ngOnInit(){
    this.productService.getProductsByIdCategory('3').subscribe((data) => {
      // if (this.product.id_Category = 3)
      this.products = data as Product[];
      this.cdr.detectChanges();
    });
  }
}

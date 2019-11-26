import {ChangeDetectorRef, Component} from "@angular/core";
import {Product} from "../products/product";
import {ProductService} from "../../services/product.service";

@Component({
  selector: "app-films",
  templateUrl: "./films.component.html",
  styleUrls: ['./films.component.css']
})
export class FilmsComponent {
  products: Product[];

  constructor(private productService: ProductService,
              private cdr: ChangeDetectorRef,) {}

  ngOnInit(){
    this.productService.getProductsByIdCategory('1').subscribe((data) => {
      this.products = data as Product[];
      this.cdr.detectChanges();
    });
  }
}

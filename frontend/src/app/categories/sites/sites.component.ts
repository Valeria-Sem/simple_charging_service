import {ChangeDetectorRef, Component} from "@angular/core";
import {Product} from "../products/product";
import {ProductService} from "../../services/product.service";

@Component({
  selector: "app-sites",
  templateUrl: "./sites.component.html",
  styleUrls: ['./sites.component.css']
})
export class SitesComponent {
  products: Product[];

  constructor(private productService: ProductService,
              private cdr: ChangeDetectorRef,) {}

  ngOnInit(){
    this.productService.getProductsByIdCategory('4').subscribe((data) => {
      this.products = data as Product[];
      this.cdr.detectChanges();
    });
  }
}

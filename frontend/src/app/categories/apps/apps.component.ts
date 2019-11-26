import {ChangeDetectorRef, Component} from "@angular/core";
import {Product} from "../products/product";
import {ProductService} from "../../services/product.service";

@Component({
  selector: "app-apps",
  templateUrl: "./apps.component.html",
  styleUrls: ['./apps.component.css']
})
export class AppsComponent {
  products: Product[];

  constructor(private productService: ProductService,
              private cdr: ChangeDetectorRef,) {}

  ngOnInit(){
    this.productService.getProductsByIdCategory('2').subscribe((data) => {
      this.products = data as Product[];
      this.cdr.detectChanges();
    });
  }
}

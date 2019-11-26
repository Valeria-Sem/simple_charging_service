import {ChangeDetectorRef, Component} from "@angular/core";
import {Product} from "../products/product";
import {ProductService} from "../../services/product.service";

@Component({
  selector: "app-music",
  templateUrl: "./music.component.html",
  styleUrls: ['./music.component.css']
})
export class MusicComponent {
  products: Product[];

  constructor(private productService: ProductService,
              private cdr: ChangeDetectorRef,) {}

  ngOnInit(){
    this.productService.getProductsByIdCategory('5').subscribe((data) => {
      this.products = data as Product[];
      this.cdr.detectChanges();
    });
  }
}

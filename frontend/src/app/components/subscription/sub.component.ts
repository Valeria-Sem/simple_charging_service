import {ChangeDetectorRef, Component, TemplateRef} from "@angular/core";
import {Product} from "../../modules/product";
import {Status, Wallet} from "../../modules/wallet";
import {Role, User} from "../../modules/user";
import {Subscription, SubStatus} from "../../modules/subscription";
import {ProductService} from "../../services/product.service";
import {WalletService} from "../../services/wallet.service";
import {BsModalService} from "ngx-bootstrap";
import {SubService} from "../../services/subscription.service";
import {UserService} from "../../services/user.service";
import {CustProd} from "../../modules/CustProd";
import {Page} from "../../modules/page";

@Component({
  selector: "app-sub",
  templateUrl: "./sub.component.html",
  styleUrls: ['./sub.component.css']
})
export class SubComponent {
  products: Page;
  public wallet: Wallet;
  public user: User = this.userService.currentUser;
  public newBalance: number;
  public walletStatus: Status = Status.ACTIVE;
  public balance: number;
  product: Product;
  subscription: Subscription;
  public subscriptionStatus: SubStatus = 0;
  dateOfSub: Date;
  isCust: boolean = false;
  cust: string = Role.CUSTOMER;
  custProd: CustProd[];
  currentPage: number = 0;
  page: number;

  constructor(private productService: ProductService,
              private walletService: WalletService,
              private cdr: ChangeDetectorRef,
              private subService: SubService,
              private userService: UserService) {}


  pageChanged(event: any): void {
    this.currentPage = event.page - 1;
    if(this.user.role !== this.cust) {
      this.productService.getProductsByIdOrganisation(this.user.idOrganisation, this.currentPage, 6).subscribe((data) => {
        this.products = data as Page;
        this.cdr.detectChanges();
      });
    } else {
      this.subService.getSub(this.user.idCustomer).subscribe((data) => {
        this.custProd = data as CustProd[];
      });}
  }

  ngOnInit(){
    if(this.user.role !== this.cust){
      this.productService.getProductsByIdOrganisation(this.user.idOrganisation,this.currentPage,6).subscribe((data) => {
        this.products = data as Page;
        this.cdr.detectChanges();
      });
    } else {
      this.subService.getSub(this.user.idCustomer).subscribe((data) => {
      this.custProd = data as CustProd[];
    });

    }
    this.isCust = this.user.role == this.cust;
  }


  public unsubscribe(idSub){
    this.subService.unsubscribe(idSub).subscribe(() => {
      this.custProd = this.custProd.filter(product => {
        return product.idSubscription !== idSub;
      })
    });
  }

  public deleteProduct(idProd: string){
    this.productService.deleteProduct(idProd).subscribe(() => {
      this.productService.getProductsByIdOrganisation(this.user.idOrganisation,this.currentPage,6).subscribe((data) => {
        this.products = data as Page;
        this.cdr.detectChanges();
      });
    });
  }
}

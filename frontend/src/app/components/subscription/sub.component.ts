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
  public walletStatus: Status = 0;
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
    this.productService.getProductsByIdOrganisation(this.user.idOrganisation,this.currentPage,6).subscribe((data) => {
      this.products = data as Page;
      this.cdr.detectChanges();
    });

    // this.page = event.page;
  }

  ngOnInit(){
    if(this.user.role !== this.cust){
      this.productService.getProductsByIdOrganisation(this.user.idOrganisation,this.currentPage,6).subscribe((data) => {
        this.products = data as Page;
        this.cdr.detectChanges();
      });
        // this.cdr.detectChanges();
    } else {
      this.subService.getSub(this.user.idCustomer).subscribe((data) => {
      this.custProd = data as CustProd[];
      // this.cdr.detectChanges();
    });


    }


    this.isCust = this.user.role == this.cust;

  }

  public payAndSub (monthPrise, idProd): void {
    this.balance = (+this.user.balance) - (+monthPrise);
    this.wallet = new Wallet(this.user.idWallet, this.balance, this.walletStatus);
    this.walletService.payment(this.wallet).subscribe();

    this.balance = (+this.user.balance) - (+monthPrise);

    this.dateOfSub = new Date();
    this.subscription = new Subscription(idProd, this.user.idCustomer, this.subscriptionStatus, this.dateOfSub);
    this.subService.subscribeCustomer(this.subscription, this.user.idCustomer, idProd).subscribe();

    // todo добавление денег организации
    // this.wallet = new Wallet(this.user.idWallet, this.balance, this.walletStatus);
  }

  public unsubscribe(idSub){
    this.subService.unsubscribe(idSub).subscribe(() => {
      this.custProd = this.custProd.filter(product => {
        return product.idSubscription !== idSub;
      })
    });
  }
}

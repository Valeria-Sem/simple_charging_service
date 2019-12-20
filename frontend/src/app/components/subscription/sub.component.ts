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

@Component({
  selector: "app-sub",
  templateUrl: "./sub.component.html",
  styleUrls: ['./sub.component.css']
})
export class SubComponent {
  products: Product[];
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

  constructor(private productService: ProductService,
              private walletService: WalletService,
              private cdr: ChangeDetectorRef,
              private subService: SubService,
              private userService: UserService) {}

  ngOnInit(){
    this.productService.getProductsByIdOrganisation(this.user.idOrganisation).subscribe((data) => {
      this.products = data as Product[];
      this.cdr.detectChanges();
    });

    this.subService.getSub(this.user.idCustomer).subscribe((data) => {
      this.custProd = data as CustProd[];
      this.cdr.detectChanges();
    });

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
}

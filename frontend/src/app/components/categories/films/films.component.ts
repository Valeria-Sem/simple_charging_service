import {ChangeDetectorRef, Component, TemplateRef} from "@angular/core";
import {Product} from "../../../modules/product";
import {ProductService} from "../../../services/product.service";
import {Status, Wallet} from "../../../modules/wallet";
import {WalletService} from "../../../services/wallet.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription, SubStatus} from "../../../modules/subscription";
import {SubService} from "../../../services/subscription.service";
import {User} from "../../../modules/user";
import {UserService} from "../../../services/user.service";
import {Page} from "../../../modules/page";

@Component({
  selector: "app-films",
  templateUrl: "./films.component.html",
  styleUrls: ['./films.component.css']
})
export class FilmsComponent {
  public wallet: Wallet;
  public user: User = this.userService.currentUser;
  public walletStatus: Status = 0;
  public balance: number;
  product: Product;
  modalRef: BsModalRef;
  subscription: Subscription;
  public subscriptionStatus: SubStatus = 0;
  dateOfSub: Date;
  currentPage: number = 0;
  page: number;
  products: Page;

  constructor(private productService: ProductService,
              private walletService: WalletService,
              private cdr: ChangeDetectorRef,
              private modalService: BsModalService,
              private subService: SubService,
              private userService: UserService) {}

  pageChanged(event: any): void {
    this.currentPage = event.page - 1;
    this.productService.getProductsByIdCategory('1',this.currentPage,6).subscribe((data) => {
      this.products = data as Page;
      this.cdr.detectChanges();
    });
  }

  ngOnInit(){
    this.productService.getProductsByIdCategory('1',this.currentPage,6).subscribe((data) => {
      this.products = data as Page;
      this.cdr.detectChanges();
    });
  }

  public payAndSub (monthPrise, template: TemplateRef<any>, idProd): void {
    this.balance = (+this.user.balance) - (+monthPrise);
    this.wallet = new Wallet(this.user.idWallet, this.balance, this.walletStatus);
    this.walletService.payment(this.wallet).subscribe( () =>{
      this.userService.currentUser.balance = this.balance;
    });

    this.balance = (+this.user.balance) - (+monthPrise);
    this.modalRef = this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));;

    this.dateOfSub = new Date();
    this.subscription = new Subscription(idProd, this.user.idCustomer, this.subscriptionStatus, this.dateOfSub);
    this.subService.subscribeCustomer(this.subscription, this.user.idCustomer, idProd).subscribe();

    // todo добавление денег организации
   // this.wallet = new Wallet(this.user.idWallet, this.balance, this.walletStatus);
  }
}

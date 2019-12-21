import {ChangeDetectorRef, Component, TemplateRef, ViewChild} from "@angular/core";
import {Product} from "../../../modules/product";
import {ProductService} from "../../../services/product.service";
import {Status, Wallet} from "../../../modules/wallet";
import {WalletService} from "../../../services/wallet.service";
import {BsModalRef, BsModalService, ModalDirective} from "ngx-bootstrap";
import {Subscription, SubStatus} from "../../../modules/subscription";
import {SubService} from "../../../services/subscription.service";
import {User} from "../../../modules/user";
import {UserService} from "../../../services/user.service";
import {Page} from "../../../modules/page";
import {CustProd} from "../../../modules/CustProd";

@Component({
  selector: "app-sites",
  templateUrl: "./sites.component.html",
  styleUrls: ['./sites.component.css']
})
export class SitesComponent {
  @ViewChild('childModal', {read: false}) childModal: ModalDirective;
  products: Page;
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
  custProd: CustProd[];

  constructor(private productService: ProductService,
              private userService: UserService,
              private walletService: WalletService,
              private cdr: ChangeDetectorRef,
              private modalService: BsModalService,
              private subService: SubService) {
  }

  hideChildModal(): void {
    this.childModal.hide();
  }

  pageChanged(event: any): void {
    this.currentPage = event.page - 1;
    this.productService.getProductsByIdCategory('4',this.currentPage,6).subscribe((data) => {
      this.products = data as Page;
      this.cdr.detectChanges();
    });
  }

  public getCustomerSubs(){
    this.subService.getSub(this.user.idCustomer).subscribe((dataProd) => {
      this.custProd = dataProd;

      this.products.productEntities.forEach((product) => {

        this.custProd.forEach((subscription) => {
          if (product.name == subscription.name) {
            let element: HTMLElement = document.getElementById(subscription.name);
            element.classList.add('disabled');
          }
        })
      })
    });
  }

  ngOnInit(){
    this.productService.getProductsByIdCategory('4',this.currentPage,6).subscribe((data) => {
      this.products = data as Page;
      this.getCustomerSubs();
    });
  }

  public payAndSub (monthPrise, template: TemplateRef<any>, idProd, idOrg): void {
    if (this.user.balance < monthPrise) {
      this.childModal.show();
    } else {
      this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
      this.balance = (+this.user.balance) - (+monthPrise);
      this.wallet = new Wallet(this.user.idWallet, this.balance, this.walletStatus);
      this.walletService.payment(this.wallet).subscribe(() => {
        this.userService.currentUser.balance = this.balance;
        localStorage.setItem("user", JSON.stringify(this.userService.currentUser));
      });

      this.dateOfSub = new Date();
      this.subscription = new Subscription(idProd, this.user.idCustomer, this.subscriptionStatus, this.dateOfSub);
      this.subService.subscribeCustomer(this.subscription, this.user.idCustomer, idProd).subscribe();

      this.walletService.balanceReplenishmentByOrg(idOrg, monthPrise).subscribe( () =>{
        this.getCustomerSubs();
      });
    }
  }
}

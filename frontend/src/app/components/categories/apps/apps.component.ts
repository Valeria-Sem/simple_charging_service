import {ChangeDetectorRef, Component, TemplateRef} from "@angular/core";
import {Product} from "../../../modules/product";
import {ProductService} from "../../../services/product.service";
import {Status, Wallet} from "../../../modules/wallet";
import {CusRegistration} from "../../../modules/cusRegistration";
import {CustomerService} from "../../../services/customer.sevice";
import {WalletService} from "../../../services/wallet.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";


@Component({
  selector: "app-apps",
  templateUrl: "./apps.component.html",
  styleUrls: ['./apps.component.css']
})
export class AppsComponent {
  products: Product[];
  public wallet: Wallet;
  public customer: CusRegistration = this.customerService.currentCustomer;
  public newBalance: number;
  public walletStatus: Status = 0;
  public balance: number;
  product: Product;
  modalRef: BsModalRef;


  constructor(private productService: ProductService,
              private customerService: CustomerService,
              private walletService: WalletService,
              private cdr: ChangeDetectorRef,
              private modalService: BsModalService) {

  }

  // openModal(template: TemplateRef<any>) {
  //   this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  // }

  ngOnInit(){
    this.productService.getProductsByIdCategory('2').subscribe((data) => {
      this.products = data as Product[];
      this.cdr.detectChanges();
    });
  }

  public payment (monthPrise, template: TemplateRef<any>): void {
    this.balance = (+this.customer.balance) - (+monthPrise);
    this.wallet = new Wallet(this.customer.idWallet, this.balance, this.walletStatus);
    this.walletService.payment(this.wallet).subscribe();
    this.balance = (+this.customer.balance) - (+monthPrise);
    this.modalRef = this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));;

    // todo добавление денег организации
 //   this.wallet = new Wallet(this.customer.idWallet, this.balance, this.walletStatus);
  }
}

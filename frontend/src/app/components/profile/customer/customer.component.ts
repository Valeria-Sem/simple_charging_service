import {Component, OnInit, TemplateRef} from "@angular/core";
import {CustomerService} from "../../../services/customer.sevice";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {tap} from "rxjs/operators";
import {Customer} from "../../../modules/customer";
import {Status, Wallet} from "../../../modules/wallet";
import {WalletService} from "../../../services/wallet.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CusRegistration} from "../../../modules/cusRegistration";

@Component({
  selector: "app-cusProf",
  templateUrl: "./customer.component.html",
  styleUrls: ['./customer.component.css']
})
export class CustomerProfileComponent implements OnInit {
  public wallet: Wallet;
  public customer: CusRegistration = this.customerService.currentCustomer;
  public newBalance: number;
  public walletStatus: Status = 0;
  public balance: number;
  modalRef: BsModalRef;

  constructor(private customerService: CustomerService,
              private modalService: BsModalService,
              private walletService: WalletService,
              private loadingService: Ng4LoadingSpinnerService) {
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  }

  ngOnInit() {
    console.log(1);
    console.log(this.customerService);
  //  this.loadUserWallet(this.customer.idWallet);
    // this.customerService.currentCustomer$.subscribe(v => console.log(v))
  }

  public replenishBalance (): void {
    this.balance = (+this.customer.balance) + (+this.newBalance);
    this.wallet = new Wallet(this.customer.idWallet, this.balance, this.walletStatus);
    this.walletService.balanceReplenishment(this.wallet).subscribe();
  }

  // private loadUserWallet(walletUserId: string): void {
  //   this.loadingService.show();
  // }

}

import {Component, OnInit, TemplateRef} from "@angular/core";
import {CustomerService} from "../../services/customer.sevice";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {tap} from "rxjs/operators";
import {Customer} from "../../registration/customer";
import {Status, Wallet} from "../../registration/wallet";
import {WalletService} from "../../services/wallet.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Registration} from "../../registration/registration";

@Component({
  selector: "app-orgProf",
  templateUrl: "./organisation.component.html",
  styleUrls: ['./organisation.component.css']
})
export class OrganisationProfileComponent implements OnInit {
  public wallet: Wallet;
  public customer: Registration = this.customerService.currentCustomer;
  public newBalance: number;
  public walletStatus: Status = 0;
  public balance: number;
  modalRef: BsModalRef;

  constructor(private customerService: CustomerService,
              private modalService: BsModalService,
              private walletService: WalletService,
              private loadingService: Ng4LoadingSpinnerService) {
  }

  // openModal(template: TemplateRef<any>) {
  //   this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  // }

  ngOnInit() {
    console.log(1);
    console.log(this.customerService);
  //  this.loadUserWallet(this.customer.idWallet);
    // this.customerService.currentCustomer$.subscribe(v => console.log(v))
  }

  // public replenishBalance (): void {
  //   this.balance = (+this.customer.balance) + (+this.newBalance);
  //   this.wallet = new Wallet(this.customer.idWallet, this.balance, this.walletStatus);
  //   this.walletService.balanceReplenishment(this.wallet).subscribe();
  // }

  // private loadUserWallet(walletUserId: string): void {
  //   this.loadingService.show();
  // }

}

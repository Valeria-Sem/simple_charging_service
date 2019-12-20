import {Component, OnInit, TemplateRef} from "@angular/core";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Status, Wallet} from "../../modules/wallet";
import {WalletService} from "../../services/wallet.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../services/user.service";
import {Role, User} from "../../modules/user";
import {Observable, of} from "rxjs";
import {tap} from "rxjs/operators";

@Component({
  selector: "app-cusProf",
  templateUrl: "./user.component.html",
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public wallet: Wallet;
  public user: User = this.userService.currentUser;
  // public user$: Observable<User> = this.userService.currentUser$
  //   .pipe(tap(currentUser => this.user = currentUser));
  public newBalance: number;
  public walletStatus: Status = 0;
  public balance: number;
  modalRef: BsModalRef;
  //orgDiv: boolean = false;
  //custDiv: boolean = false;
  isCust: boolean = false;
  cust: string = Role.CUSTOMER;

  constructor(private userService: UserService,
              private modalService: BsModalService,
              private walletService: WalletService,
              private loadingService: Ng4LoadingSpinnerService) {
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  }

  ngOnInit() {
    this.userService.currentUser$
      .pipe(tap(currentUser => this.user = currentUser))
      .subscribe()
     console.log("user role", this.user.role === Role.CUSTOMER);
    // console.log("user role", Role.1);
    this.isCust = this.user.role == this.cust;
    console.log(this.user);
    console.log(Role.CUSTOMER);
    console.log(typeof this.user.role);
    console.log(typeof this.isCust);



  }

  public replenishBalance (): void {
    this.balance = (+this.user.balance) + (+this.newBalance);
    this.wallet = new Wallet(this.user.idWallet, this.balance, this.walletStatus);
    this.walletService.balanceReplenishment(this.wallet).subscribe();
  }

}

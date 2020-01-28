import {Component, OnInit, TemplateRef, ViewChild} from "@angular/core";
import {BsModalRef, BsModalService, ModalDirective} from "ngx-bootstrap";
import {Status, Wallet} from "../../modules/wallet";
import {WalletService} from "../../services/wallet.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../services/user.service";
import {Role, User} from "../../modules/user";
import {tap} from "rxjs/operators";
import {Router} from "@angular/router";

@Component({
  selector: "app-cusProf",
  templateUrl: "./user.component.html",
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  @ViewChild('childModal', {read: false}) childModal: ModalDirective;
  public wallet: Wallet;
  public user: User = this.userService.currentUser;
  // public user$: Observable<User> = this.userService.currentUser$
  //   .pipe(tap(currentUser => this.user = currentUser));
  public newBalance: number;
  public walletStatus: Status = Status.ACTIVE;
  public balance: number;
  modalRef: BsModalRef;
  //orgDiv: boolean = false;
  //custDiv: boolean = false;
  isCust: boolean = false;
  cust: string = Role.CUSTOMER;
  user$ = this.userService.currentUser$;
  normalBalance: number = 5000;

  constructor(private userService: UserService,
              private modalService: BsModalService,
              private walletService: WalletService,
              private loadingService: Ng4LoadingSpinnerService,
              private router: Router) {
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  }

  hideChildModal(): void {
    this.childModal.hide();
  }

  ngOnInit() {
    this.userService.currentUser$
      .pipe(tap(currentUser => this.user = currentUser))
      .subscribe();
    this.isCust = this.user.role == this.cust;
  }

  public replenishBalance (): void {
    if (+this.user.balance >= +this.normalBalance){
      this.childModal.show();
    } else {
      this.balance = (+this.user.balance) + (+this.newBalance);
      this.wallet = new Wallet(this.user.idWallet, this.balance, this.walletStatus);
      this.walletService.balanceReplenishment(this.wallet).subscribe( () =>{
        this.userService.currentUser.balance = this.balance;
        this.userService.currentUser.walletStatus = Status.ACTIVE;
        localStorage.setItem("user", JSON.stringify(this.userService.currentUser));
      });
      // this.userService.currentUser.balance = this.balance;
      this.modalRef.hide();
    }
  }

  public clickBalance(template: TemplateRef<any>){
    if (+this.user.balance >= +this.normalBalance){
      this.childModal.show();
    } else {
      this.openModal(template)
    }
  }

  public deleteAcc(){
    this.userService.deleteUser(+this.user.idUser, this.user.idWallet).subscribe(() => {
      this.userService.setUser(null);
      localStorage.removeItem("user");
      this.router.navigate(['/']);
    });
  }

}

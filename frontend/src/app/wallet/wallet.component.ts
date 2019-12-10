// import {Component} from "@angular/core";
// import {WalletService} from "../services/wallet.service";
// import {Status, Wallet} from "../registration/wallet";
// import {Subscription} from "rxjs";
// import {FormGroup} from "@angular/forms";
//
// @Component({
//   selector: "app-useReg",
//   templateUrl: "./user.registration.component.html",
//   styleUrls: ['./user.registration.component.css']
// })
// export class WalletComponent {
//   information: Wallet;
//   public balance: string;
//   public walletStatus: Status ;
//   private subscriptions: Subscription[] = [];
//   wallet$ = this.walletService.currentWallet$;
//
//   constructor(private walletService:WalletService) {
//   }
//
//   ngOnInit(){
//   }
//
//   public getWalletById(idWallet): void {
//     this.subscriptions.push(
//       this.walletService.getWalletById(idWallet).subscribe(() => {
//         this.information = new Wallet(this.balance, this.walletStatus);
//         }
//       )
//     );
//   }
//
//   public balanceReplenishment(information): void {
//     this.information = new Wallet(this.balance, this.walletStatus);
//     this.walletService.balanceReplenishment(this.information).subscribe();
//   }
// }

import {Component, OnInit, TemplateRef} from "@angular/core";
import {CustomerService} from "../../services/customer.sevice";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {tap} from "rxjs/operators";
import {Customer} from "../../registration/customer";
import {Wallet} from "../../registration/wallet";

@Component({
  selector: "app-cusProf",
  templateUrl: "./customer.component.html",
  styleUrls: ['./customer.component.css']
})
export class CustomerProfileComponent implements OnInit {
  public wallet: Wallet;
  public customer: Customer = this.customerService.currentCustomer;
  public newBalance: string;
  modalRef: BsModalRef;

  constructor(private customerService: CustomerService,
              private modalService: BsModalService) {
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  }

  ngOnInit() {
    console.log(1);
    console.log(this.customerService);
    // this.customerService.currentCustomer$.subscribe(v => console.log(v))
  }

  public replenishBalance (newBalance): void {
    this.wallet = new Wallet(newBalance);

  }



}

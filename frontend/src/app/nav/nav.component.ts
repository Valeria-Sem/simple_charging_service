import { Component, OnInit } from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import { TemplateRef } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css'],

})
// @Component({
//   selector: 'app-modal',
//   templateUrl: './nav.component.html'
// })

// export class ModalComponent {
//   modalRef: BsModalRef;
//
//   constructor(private modalService: BsModalService) {
//   }
//
//   openModal(template: TemplateRef<any>) {
//     this.modalRef = this.modalService.show(template);
//   }
// }

export class NavComponent implements OnInit {
  loaded : boolean ;
  modalRef: BsModalRef;

  constructor(private modalService: BsModalService) {
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  ngOnInit() {
    this.loaded = true
  }

}





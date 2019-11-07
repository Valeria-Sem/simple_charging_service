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
    this.modalRef = this.modalService.show(template, Object.assign({}, { class: 'gray modal-sm' }));
  }

  ngOnInit() {
    this.loaded = true

  }

  items: string[] = [
    'The first choice!',
    'And another choice for you.',
    'but wait! A third!'
  ];

  onHidden(): void {
    console.log('Dropdown is hidden');
  }
  onShown(): void {
    console.log('Dropdown is shown');
  }
  isOpenChange(): void {
    console.log('Dropdown state is changed');
  }

}





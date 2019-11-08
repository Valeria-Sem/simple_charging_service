import {Component, Inject, OnInit} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import { TemplateRef } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../nav/categories/category"
import {CategoryService} from "../services/category.service";

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
  items : any;

  constructor(private modalService: BsModalService, categorySerevice : CategoryService) {

    categorySerevice.getCategories().subscribe((data:any) => {
      this.items = data
      console.log("asdf" + this.items)
    }, error => {
      console.log("error: " + JSON.stringify(error))
    });
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, { class: 'gray modal-sm' }));
  }

  ngOnInit() {
    this.loaded = true

  }

  // items: string[] = [
  //   'The first choice!',
  //   'And another choice for you.',
  //   'but wait! A third!'
 // ];

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









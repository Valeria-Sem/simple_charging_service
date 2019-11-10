import {ChangeDetectorRef, Component, Inject, OnInit} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {TemplateRef} from '@angular/core';
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
  loaded: boolean;
  modalRef: BsModalRef;
  categories: Category[];

  constructor(private modalService: BsModalService, private categoryService: CategoryService,
              private cdr: ChangeDetectorRef) {
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  }

  ngOnInit() {
    this.loaded = true;
    this.categoryService.getCategories().subscribe((data) => {
      this.categories = data as Category[];
      this.cdr.detectChanges();
      // }, error => {
      //   console.log("error: " + JSON.stringify(error))
    });

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









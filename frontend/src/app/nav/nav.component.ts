import {ChangeDetectorRef, Component, Inject, OnInit} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {TemplateRef} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subscription} from "rxjs";
import {Category} from "../nav/categories/category"
import {CategoryService} from "../services/category.service";
import {Organisation} from "./organisations/organisation";
import {OrganisationService} from "../services/organisation.service";
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {UserService} from "../services/user.service";
import {User} from "./user/user";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css'],

})

export class NavComponent implements OnInit {
  loaded: boolean;
  modalRef: BsModalRef | null;
  modalRef2: BsModalRef;
  categories: Category[];
  organisations: Organisation[];
  myForm: FormGroup;
  private subscriptions: Subscription[] = [];
  // private login: string;
  loginForm: FormGroup;

  constructor(private modalService: BsModalService, private organisationService: OrganisationService, private categoryService: CategoryService,
              private cdr: ChangeDetectorRef, private formBuilder: FormBuilder, private userService: UserService) {
    //private userService: UserService
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  }

  openModal2(template: TemplateRef<any>) {
    this.modalRef2 = this.modalService.show(template, { class: 'second' });
  }

  // closeFirstModal() {
  //   if (!this.modalRef) {
  //     return;
  //   }
  //
  //   this.modalRef.hide();
  //   this.modalRef = null;
  // }

  ngOnInit() {
    this.loaded = true;
    this.categoryService.getCategories().subscribe((data) => {
      this.categories = data as Category[];
      this.cdr.detectChanges();
      // }, error => {
      //   console.log("error: " + JSON.stringify(error))
    });

    this.organisationService.getOrganisation().subscribe((data) => {
      this.organisations = data as Organisation[];
      this.cdr.detectChanges();
      // }, error => {
      //   console.log("error: " + JSON.stringify(error))
    });

    this.myForm = this.formBuilder.group({
      radio: ''
    });

    this.loginForm = new FormGroup({
      "userLogin": new FormControl("", [Validators.required, Validators.pattern("[a-zA-Z_.]+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}")]),
      "userPassword": new FormControl("", Validators.required)
    });

  }

  public getUserByLogin(login): void {
    this.subscriptions.push(this.userService.getUserByLogin(login).subscribe(user => {
      this.userService.currentUser = user as User;
    }));
  }

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











import {ChangeDetectorRef, Component, Inject, OnInit} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {TemplateRef} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subject, Subscription} from "rxjs";
import {Category} from "../../modules/category"
import {CategoryService} from "../../services/category.service";
import {Organisation} from "../../modules/organisation";
import {OrganisationService} from "../../services/organisation.service";
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {UserService} from "../../services/user.service";
import {User} from "../../modules/user";
import {Router} from "@angular/router";
import {tap} from "rxjs/operators";
import {Product} from "../../modules/product";
import {ProductService} from "../../services/product.service";
import { BsDropdownConfig } from 'ngx-bootstrap/dropdown';
import {Customer} from "../../modules/customer";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css'],
  providers: [{ provide: BsDropdownConfig, useValue: { isAnimated: true, autoClose: true } }]
})

export class NavComponent implements OnInit {
  loaded: boolean;
  modalRef: BsModalRef | null;
  modalRef2: BsModalRef;
  categories: Category[];
  myForm: FormGroup;
  private subscriptions: Subscription[] = [];
  loginForm: FormGroup;
  public user: User = this.userService.currentUser;
  user$ = this.userService.currentUser$;
  //customer$ = this.customerService.currentCustomer$;
  products: Product[];
  organisation: Organisation;
  public login: string;
  public password: string;

 // unauthorizedError: string = null;

  constructor(private modalService: BsModalService,
              private organisationService: OrganisationService,
              private categoryService: CategoryService,
              private cdr: ChangeDetectorRef,
              private formBuilder: FormBuilder,
              private userService: UserService,
              private router: Router,
              private productService: ProductService) {
    //private userService: UserService
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  }

  openModal2(template: TemplateRef<any>) {
    this.modalRef.hide();
    this.modalRef2 = this.modalService.show(template, {class: 'second'});
  }

  closeModal2(template: TemplateRef<any>) {
    this.modalRef2.hide();
  }

  ngOnInit() {

    this.loaded = true;
    this.categoryService.getCategories().subscribe((data) => {
      this.categories = data as Category[];
      this.cdr.detectChanges();
    });

    this.myForm = this.formBuilder.group({
      radio: ''
    });

    this.loginForm = new FormGroup({
      "userLogin": new FormControl("", [Validators.required]),
      "userPassword": new FormControl("", Validators.required)
    });
  }

  public getUserInfo(login, password): void {
    // console.log(this.loginForm);
    this.subscriptions.push(
      this.userService.getUserInfo(login, password)
        .subscribe(() => {
            this.modalRef.hide();
          }
        )
    )
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

  public logout(): void {
    this.userService.setUser(null);
    localStorage.removeItem("user");
    this.router.navigate(['/']);
  }

}











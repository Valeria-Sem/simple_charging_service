import {ChangeDetectorRef, Component, Inject, OnInit} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {TemplateRef} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subscription} from "rxjs";
import {Category} from "../../modules/category"
import {CategoryService} from "../../services/category.service";
import {Organisation} from "../../modules/organisation";
import {OrganisationService} from "../../services/organisation.service";
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {UserService} from "../../services/user.service";
import {User} from "../../modules/user";
import {Router} from "@angular/router";
import {CustomerService} from "../../services/customer.sevice";
import {tap} from "rxjs/operators";
import {Product} from "../../modules/product";
import {ProductService} from "../../services/product.service";

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
  //user$ = this.userService.currentUser$;
  customer$ = this.customerService.currentCustomer$;
  products: Product[];
  organisation: Organisation;

  constructor(private modalService: BsModalService,
              private organisationService: OrganisationService,
              private categoryService: CategoryService,
              private cdr: ChangeDetectorRef,
              private formBuilder: FormBuilder,
              private userService: UserService,
              private customerService: CustomerService,
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
  // todo фильтрация по организациям, если будет время
    // this.organisationService.getOrganisation().subscribe((data) => {
    //   this.organisations = data as Organisation[];
    //   this.cdr.detectChanges();
    // });

    this.myForm = this.formBuilder.group({
      radio: ''
    });

    this.loginForm = new FormGroup({
      "userLogin": new FormControl("", [Validators.required, Validators.pattern("[a-zA-Z_.]+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}")]),
      "userPassword": new FormControl("", Validators.required)
    });

    // if (this.customer$ != null){
    //   localStorage.setItem('user',JSON.stringify(this.customer$))
    // }

   // localStorage.setItem('user',JSON.stringify(this.customer$));
  }

  public getCustomerProfileInfo(login, password): void {
    localStorage.setItem('user',JSON.stringify( this.subscriptions.push(
      this.customerService.getCustomerProfileInfo(login, password)
        .subscribe(() => {
            // this.userService.currentUser = user as User;
            // localStorage.setItem('user',JSON.stringify(this.customer$));
            this.modalRef.hide();
          }
        )
    )));
    // this.subscriptions.push(
    //   this.customerService.getCustomerProfileInfo(login, password)
    //     .subscribe(() => {
    //         // this.userService.currentUser = user as User;
    //        // localStorage.setItem('user',JSON.stringify(this.customer$));
    //         this.modalRef.hide();
    //       }
    //     )
    // );
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
    this.customerService.setCustomer(null);
    this.router.navigate(['/']);
  }



}











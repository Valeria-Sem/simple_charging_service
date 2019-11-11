import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TooltipModule } from "ngx-bootstrap/tooltip";
import { ModalModule } from 'ngx-bootstrap/modal';
import { FormsModule } from "@angular/forms";
import { routing } from './app.routing';

import { AppComponent } from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {RouterModule, Routes} from "@angular/router";
import { NavComponent } from "./nav/nav.component";
import {HomeComponent} from "./home/home.component";
import { CarouselComponent } from "./carousel/carousel.component";
import {CarouselModule} from "ngx-bootstrap";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
//import {UsersDetalisComponent} from "./modules/components/detalis/users-detalis";
//import { ModalComponent } from "./modal/modal.component";


// const appRoutes: Routes = [
//   {path: "", component: HomeComponent},
//   {path: "home", component: HomeComponent},
//   {path: "billing-details/:id", component: BillingDetailsViewComponent},
//   {path: "**", component: NotFoundComponent}
// ];

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    CarouselComponent,
    //  UsersDetalisComponent
    //ModalComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    routing,
    CarouselModule.forRoot(),
    BrowserAnimationsModule,
    BsDropdownModule.forRoot()

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

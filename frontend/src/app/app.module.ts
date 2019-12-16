import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TooltipModule } from "ngx-bootstrap/tooltip";
import { ModalModule } from 'ngx-bootstrap/modal';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { routing } from './app.routing';

import { AppComponent } from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {RouterModule, Routes} from "@angular/router";
import { NavComponent } from "./nav/nav.component";
import {HomeComponent} from "./home/home.component";
import { CarouselComponent } from "./carousel/carousel.component";
import {ButtonsModule, CarouselModule} from "ngx-bootstrap";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AboutComponent} from "./about/about.component";
import {User} from "./nav/user/user";
import {UserRegComponent} from "./registration/userReg/user.registration.component";
import {OrganisationRegComponent} from "./registration/organisationReg/org.registration.component";
import {FooterComponent} from "./footer/footer.component";
import {FilmsComponent} from "./categories/films/films.component";
import {AppsComponent} from "./categories/apps/apps.component";
import {GamesComponent} from "./categories/games/game.component";
import {MusicComponent} from "./categories/music/music.component";
import {SitesComponent} from "./categories/sites/sites.component";
import {CustomerProfileComponent} from "./profile/customer/customer.component";
import {CustomerService} from "./services/customer.sevice";
import {OrganisationProfileComponent} from "./profile/organisation/organisation.component";
// import {WalletComponent} from "./wallet/wallet.component";



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
    AboutComponent,
    UserRegComponent,
    OrganisationRegComponent,
    FooterComponent,
    FilmsComponent,
    AppsComponent,
    GamesComponent,
    MusicComponent,
    SitesComponent,
    CustomerProfileComponent,
    OrganisationProfileComponent
    //WalletComponent
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
    BsDropdownModule.forRoot(),
    ReactiveFormsModule,
    ButtonsModule.forRoot()

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

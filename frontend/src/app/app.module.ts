import { BrowserModule } from "@angular/platform-browser";
import {APP_INITIALIZER, NgModule} from "@angular/core";
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TooltipModule } from "ngx-bootstrap/tooltip";
import { ModalModule } from 'ngx-bootstrap/modal';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { routing } from './app.routing';
import { PaginationModule } from 'ngx-bootstrap/pagination';

import { AppComponent } from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {Router, RouterModule, Routes} from "@angular/router";
import { NavComponent } from "./components/nav/nav.component";
import {HomeComponent} from "./components/home/home.component";
import { CarouselComponent } from "./components/carousel/carousel.component";
import {ButtonsModule, CarouselModule} from "ngx-bootstrap";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AboutComponent} from "./components/about/about.component";
import {User} from "./modules/user";
import {UserRegComponent} from "./components/registration/customerReg/customer.registration.component";
import {OrganisationRegComponent} from "./components/registration/organisationReg/org.registration.component";
import {FooterComponent} from "./components/footer/footer.component";
import {FilmsComponent} from "./components/categories/films/films.component";
import {AppsComponent} from "./components/categories/apps/apps.component";
import {GamesComponent} from "./components/categories/games/game.component";
import {MusicComponent} from "./components/categories/music/music.component";
import {SitesComponent} from "./components/categories/sites/sites.component";
import {UserComponent} from "./components/profile/user.component";
import {CustomerService} from "./services/customer.sevice";
import {initApp} from "./services/app.initializer";
import {UserService} from "./services/user.service";
import {RoleGuard} from "./services/role-guard.service";
import {SubComponent} from "./components/subscription/sub.component";
import {ConstructorComponent} from "./components/constructor/constructor.component";
import {NotFoundComponent} from "./notFound/notFound.component";
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
    UserComponent,
    SubComponent,
    ConstructorComponent,
    NotFoundComponent
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
    ButtonsModule.forRoot(),
    PaginationModule.forRoot()

  ],
  providers: [
    RoleGuard,
    UserService,
    {
      provide: APP_INITIALIZER,
      useFactory: initApp,
      deps: [UserService],
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

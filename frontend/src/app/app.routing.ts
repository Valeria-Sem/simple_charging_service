import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {HomeComponent} from './components/home/home.component';
import {AboutComponent} from "./components/about/about.component";
import {UserRegComponent} from "./components/registration/customerReg/customer.registration.component";
import {FilmsComponent} from "./components/categories/films/films.component";
import {AppsComponent} from "./components/categories/apps/apps.component";
import {GamesComponent} from "./components/categories/games/game.component";
import {MusicComponent} from "./components/categories/music/music.component";
import {SitesComponent} from "./components/categories/sites/sites.component";
import {OrganisationRegComponent} from "./components/registration/organisationReg/org.registration.component";
import {UserComponent} from "./components/profile/user.component";
import {RoleGuard} from "./services/role-guard.service";
import {Role} from "./modules/user";
import {SubComponent} from "./components/subscription/sub.component";
import {ConstructorComponent} from "./components/constructor/constructor.component";
import {NotFoundComponent} from "./notFound/notFound.component";
import {NOT_FOUND_CHECK_ONLY_ELEMENT_INJECTOR} from "@angular/core/src/view/provider";


const appRoutes: Routes = [
  {path: '', component: HomeComponent}
  , {path: 'about', component: AboutComponent}
  , {path: 'userReg', component: UserRegComponent}
  , {path: 'orgReg', component: OrganisationRegComponent}
  , {path: 'films', component: FilmsComponent, canActivate: [RoleGuard], data: {role: Role.CUSTOMER}}
  , {path: 'app', component: AppsComponent, canActivate: [RoleGuard], data: {role: Role.CUSTOMER}}
  , {path: 'games', component: GamesComponent, canActivate: [RoleGuard], data: {role: Role.CUSTOMER}}
  , {path: 'music', component: MusicComponent, canActivate: [RoleGuard], data: {role: Role.CUSTOMER}}
  , {path: 'sites', component: SitesComponent, canActivate: [RoleGuard], data: {role: Role.CUSTOMER}}
  , {path: 'profile', component: UserComponent}
  , {path: 'sub', component: SubComponent}
  , {path: 'constructor', component: ConstructorComponent, canActivate: [RoleGuard], data: {role: Role.ORGANISATION}}
  // , {path: '*', component: NOT_FOUND_CHECK_ONLY_ELEMENT_INJECTOR}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);


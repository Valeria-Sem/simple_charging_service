import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import {AboutComponent} from "./components/about/about.component";
import {UserRegComponent} from "./components/registration/userReg/user.registration.component";
import {FilmsComponent} from "./components/categories/films/films.component";
import {AppsComponent} from "./components/categories/apps/apps.component";
import {GamesComponent} from "./components/categories/games/game.component";
import {MusicComponent} from "./components/categories/music/music.component";
import {SitesComponent} from "./components/categories/sites/sites.component";
import {OrganisationRegComponent} from "./components/registration/organisationReg/org.registration.component";
import {CustomerProfileComponent} from "./components/profile/customer/customer.component";
import {OrganisationProfileComponent} from "./components/profile/organisation/organisation.component";


const appRoutes : Routes = [
  { path: '', component: HomeComponent }
  ,{path: 'about', component: AboutComponent}
  ,{path: 'userReg', component: UserRegComponent}
  ,{path: 'orgReg', component: OrganisationRegComponent}
  ,{path: 'films', component: FilmsComponent}
  ,{path: 'app', component: AppsComponent}
  ,{path: 'games', component: GamesComponent}
  ,{path: 'music', component: MusicComponent}
  ,{path: 'sites', component: SitesComponent}
  ,{path: 'profile', component: CustomerProfileComponent}
  ,{path: 'orgProfile', component: CustomerProfileComponent}
];

export const routing : ModuleWithProviders = RouterModule.forRoot(appRoutes);


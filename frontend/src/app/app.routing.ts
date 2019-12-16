import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import {AboutComponent} from "./about/about.component";
import {UserRegComponent} from "./registration/userReg/user.registration.component";
import {FilmsComponent} from "./categories/films/films.component";
import {AppsComponent} from "./categories/apps/apps.component";
import {GamesComponent} from "./categories/games/game.component";
import {MusicComponent} from "./categories/music/music.component";
import {SitesComponent} from "./categories/sites/sites.component";
import {OrganisationRegComponent} from "./registration/organisationReg/org.registration.component";
import {CustomerProfileComponent} from "./profile/customer/customer.component";
import {OrganisationProfileComponent} from "./profile/organisation/organisation.component";


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
  ,{path: 'custProfile', component: CustomerProfileComponent}
  ,{path: 'orgProfile', component: CustomerProfileComponent}
];

export const routing : ModuleWithProviders = RouterModule.forRoot(appRoutes);


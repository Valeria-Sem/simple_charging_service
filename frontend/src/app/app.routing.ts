import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import {AboutComponent} from "./about/about.component";
import {UserRegComponent} from "./registration/userReg/user.registration.component";
import {FilmsComponent} from "./categories/films/films.component";
import {AppsComponent} from "./categories/apps/apps.component";
import {GamesComponent} from "./categories/games/game.component";



const appRoutes : Routes = [
  { path: '', component: HomeComponent }
  ,{path: 'about', component: AboutComponent}
  ,{path: 'userReg', component: UserRegComponent}
  ,{path: 'films', component: FilmsComponent}
  ,{path: 'app', component: AppsComponent}
  ,{path: 'games', component: GamesComponent}
];

export const routing : ModuleWithProviders = RouterModule.forRoot(appRoutes);

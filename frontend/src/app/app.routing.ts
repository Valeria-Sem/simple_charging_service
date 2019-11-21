import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

//import { AuthGuard } from './interceptors'

import { HomeComponent } from './home/home.component';
import {AboutComponent} from "./about/about.component";
import {UserRegComponent} from "./registration/userReg/user.registration.component";
import {FilmsComponent} from "./categories/films/films.component";
//import { ContactComponent } from './contact/contact.component'
// import { CompanyListComponent } from './companies/company-list/company-list.component';
// import { CompanyDetailComponent } from './companies/company-detail/company-detail.component';
//import { ListComponent as CompanyListComponent } from './company/list/list.component'
// import { ProfileComponent as CompanyProfileComponent } from './company/profile/profile.component'
// import { RegisterComponent as CompanyRegisterComponent } from './company/register/register.component'
//
// import { LoginComponent } from './account/login/login.component'
// import { SignupComponent } from './account/signup/signup.component'
// import { ListComponent as UserListComponent } from './account/list/list.component'
// import { EditComponent as UserEditComponent } from './account/edit/edit.component'
// import { ProfileComponent as UserProfileComponent } from './account/profile/profile.component'
// import { BalanceComponent as AccountBalanceComponent } from './account/balance/balance.component'
// import { ForgotComponent } from './account/forgot/forgot.component'
// import { ResetComponent } from './account/reset/reset.component'
// import { BonusComponent } from './company/bonus/bonus.component'


const appRoutes : Routes = [
  { path: '', component: HomeComponent }
  ,{path: 'about', component: AboutComponent}
  ,{path: 'userReg', component: UserRegComponent}
  ,{path: 'films', component: FilmsComponent}
];

export const routing : ModuleWithProviders = RouterModule.forRoot(appRoutes);

import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

//import { AuthGuard } from './interceptors'

import { HomeComponent } from './home/home.component';
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
//   , { path: 'signup', component: SignupComponent }
// //  , { path: 'contact', component: ContactComponent }
//   , { path: 'company/list' , component: CompanyListComponent }
//   , { path: 'company/register' , component: CompanyRegisterComponent }
//   , { path: 'company/:id', component: CompanyProfileComponent }
//   , { path: 'company/:id/bonus/:bid', component: BonusComponent }
//   , { path: 'account/balance', component: AccountBalanceComponent }
//   , { path: 'account/list' , component: UserListComponent }
//   , { path: 'account/edit' , component: UserEditComponent }
//   , { path: 'account/:id'  , component: UserProfileComponent }
//   , { path: 'forgot', component: ForgotComponent }
//   , { path: 'reset/:token', component: ResetComponent }
//   , { path: 'login' , component: LoginComponent }
];

export const routing : ModuleWithProviders = RouterModule.forRoot(appRoutes);

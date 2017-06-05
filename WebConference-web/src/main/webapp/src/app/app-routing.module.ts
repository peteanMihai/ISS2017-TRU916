import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./user/login/login.component";
import {RegisterComponent} from "./user/register/register.component";
import {RegisterConferenceComponent} from "./conference/conference-register/conference-register.component";
import {ProfileComponent} from "./user/profile/profile.component";
import {ConferenceDetailsComponent} from "./conference/conference-details/conference-details";
import {ListConferenceComponent} from "./conference/conference-list/conference-list.component";
const routes: Routes = [
    { path: 'home', component: HomeComponent},
    { path: 'login', component: LoginComponent},
    { path: 'register', component: RegisterComponent},
    { path: 'registerconf', component: RegisterConferenceComponent},
    { path: 'conferences/:name', component: ConferenceDetailsComponent},
    { path: 'conferences/:name/add-reviewer', component: ConferenceDetailsComponent},
    { path: 'conferences/:name/attend', component: ConferenceDetailsComponent},
    { path: 'listconf', component: ListConferenceComponent},
    { path: 'profile', component: ProfileComponent}
];
@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}

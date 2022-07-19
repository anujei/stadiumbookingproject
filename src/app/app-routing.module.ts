import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StadiumHomeComponent } from './MyComponent/stadium-home/stadium-home.component';
import { StadiumLoginComponent } from './MyComponent/stadium-login/stadium-login.component';
import { StadiumRegComponent } from './MyComponent/stadium-reg/stadium-reg.component';
import { StadiumUserlistComponent } from './MyComponent/stadium-userlist/stadium-userlist.component';
import { UserauthGuard } from './_auth/userauth.guard';

const routes: Routes = [
  { path: '', component: StadiumHomeComponent },
  { path: 'login', component: StadiumLoginComponent },
  { path: 'register', component: StadiumRegComponent },
  { path: 'user', component: StadiumUserlistComponent },
  { path: 'home', component: StadiumHomeComponent, canActivate: [UserauthGuard], data: { roles: ['Admin'] } }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

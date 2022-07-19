import { CommonModule } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StadiumAdminHeaderComponent } from './MyComponent/stadium-admin-header/stadium-admin-header.component';
import { StadiumHeaderComponent } from './MyComponent/stadium-header/stadium-header.component';
import { StadiumHomeComponent } from './MyComponent/stadium-home/stadium-home.component';
import { StadiumLoginComponent } from './MyComponent/stadium-login/stadium-login.component';
import { StadiumRegComponent } from './MyComponent/stadium-reg/stadium-reg.component';
import { StadiumUserlistComponent } from './MyComponent/stadium-userlist/stadium-userlist.component';
import { JwtClientService } from './MyService/jwt-client.service';
import { AuthInterceptor } from './_auth/auth.interceptor';
import { UserauthGuard } from './_auth/userauth.guard';

@NgModule({
  declarations: [
    AppComponent,
    StadiumRegComponent,
    StadiumLoginComponent,
    StadiumHeaderComponent,
    StadiumHomeComponent,
    StadiumAdminHeaderComponent,
    StadiumUserlistComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UserauthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    JwtClientService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

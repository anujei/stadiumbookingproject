import { CommonModule } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
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
import { AddStadiumEventComponent } from './MyComponent/add-stadium-event/add-stadium-event.component';
import { AddStadiumCategoryComponent } from './MyComponent/add-stadium-category/add-stadium-category.component';
@NgModule({
  declarations: [
    AppComponent,
    StadiumRegComponent,
    StadiumLoginComponent,
    StadiumHeaderComponent,
    StadiumHomeComponent,
    StadiumAdminHeaderComponent,
    StadiumUserlistComponent,
    AddStadiumEventComponent,
    AddStadiumCategoryComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
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

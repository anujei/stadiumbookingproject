import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from "rxjs/operators";
import { observable, Observable } from 'rxjs';
import { UserAuthServiceService } from './user-auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class JwtClientService {
  PATH_OF_API = 'http://localhost:9090';
  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });
  constructor(private http: HttpClient, private userAuthService: UserAuthServiceService) { }

  public generateToken(request: any) {
    console.log(request);
    // return this.http.post<any>('http://localhost:9090/authenticate',request);
    return this.http.post<any>(this.PATH_OF_API + '/authenticate', request, {
      headers: this.requestHeader,
    }).pipe(
      map(
        userData => {
          console.log(userData);
          sessionStorage.setItem('username', userData.userName);
          console.log(userData);
          return userData;
        }
      )
    );
  }
  welcome(): Observable<any> {
    console.log(sessionStorage.getItem("jwtToken"));
    let tokenStr = "Bearer " + sessionStorage.getItem('jwtToken');
    console.log(tokenStr);
    const headers = new HttpHeaders().set("Authorization", tokenStr);
    return this.http.get<any>(this.PATH_OF_API + '/viewUser', { headers });
  }
  viewevent(): Observable<any> {
    console.log(sessionStorage.getItem("jwtToken"));
    let tokenStr = "Bearer " + sessionStorage.getItem('jwtToken');
    console.log(tokenStr);
    const headers = new HttpHeaders().set("Authorization", tokenStr);
    return this.http.get<any>(this.PATH_OF_API + '/viewEvent', { headers });
  }

  public doRegister(user: any) {
    console.log(user);
    return this.http.post(this.PATH_OF_API + '/registerNewUser', user, {
      headers: this.requestHeader,
    });
  }

  public registerevent(event: any) {
    console.log(event);
    console.log(sessionStorage.getItem("jwtToken"));
    let tokenStr = "Bearer " + sessionStorage.getItem('jwtToken');
    console.log(tokenStr);
    const headers = new HttpHeaders().set("Authorization", tokenStr);
    return this.http.post(this.PATH_OF_API + '/createEvent', event, { headers });
  }
  public registercategory(category: any) {
    console.log(category);
    console.log(sessionStorage.getItem("jwtToken"));
    let tokenStr = "Bearer " + sessionStorage.getItem('jwtToken');
    console.log(tokenStr);
    const headers = new HttpHeaders().set("Authorization", tokenStr);
    return this.http.post(this.PATH_OF_API + '/createEvent', category, { headers });
  }

  public roleMatch(allowedRoles: string): boolean {
    let isMatch = false;
    const userRoles = this.userAuthService.getRoles();
    if (userRoles != null) {
      if (userRoles == allowedRoles) {
        isMatch = true;
      }
    }
    return isMatch;
  }
}

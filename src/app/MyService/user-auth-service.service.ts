import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthServiceService {

  constructor() { }
  public setRoles(roles:string) {
    sessionStorage.setItem('roles', roles);
  }

  public getRoles(){
    return sessionStorage.getItem('roles');
  }

  public setToken(jwtToken: string) {
    sessionStorage.setItem('jwtToken', jwtToken);
  }

  public getToken(){
    return sessionStorage.getItem('jwtToken');
  }

  public clear() {
    return sessionStorage.clear();
  }

  public isLoggedIn() {
    return this.getRoles() && this.getToken();
  }
}

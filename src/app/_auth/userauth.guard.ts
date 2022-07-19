import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { JwtClientService } from '../MyService/jwt-client.service';
import { UserAuthServiceService } from '../MyService/user-auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class UserauthGuard implements CanActivate {
  constructor(private userAuthService:UserAuthServiceService,
    private router:Router,
    private jwtclienservice:JwtClientService){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(this.userAuthService.getToken()!=null)
    {
      const role = route.data["roles"] as string;
      if(role){
        const rolematch = this.jwtclienservice.roleMatch(role);
        if(rolematch){
          return true;
        }
        else{
          this.router.navigate(["/forbidden"]);
          return false;
        }
      }
    }
    this.router.navigate(['/login'])
    return false
  }

}

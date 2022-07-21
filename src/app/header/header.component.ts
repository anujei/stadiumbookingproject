import { Component, OnInit } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(
    private userAuthService:UserAuthService ,
    private userService : UserService ) 
    { }

  ngOnInit(): void {
  }

  public isLoggedIn(){
    return this.userAuthService.isLoggedIn();
  }

  public logout()
  {
    return this.userAuthService.clear();
  }

  public isUserRoleMatch()
  {
    return this.userService.roleMatch('User');
  }

  public isAdminRoleMatch()
  {
    return this.userService.roleMatch('Admin');
  }

}

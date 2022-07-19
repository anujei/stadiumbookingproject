import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, RouterLinkWithHref } from '@angular/router';
import { User } from 'src/app/MyModel/User';
import { JwtClientService } from 'src/app/MyService/jwt-client.service';
import { UserAuthServiceService } from 'src/app/MyService/user-auth-service.service';
@Component({
  selector: 'app-stadium-login',
  templateUrl: './stadium-login.component.html',
  styleUrls: ['./stadium-login.component.css']
})
export class StadiumLoginComponent implements OnInit {
  authRequest: User=new User();
  constructor(private service:JwtClientService,
    private userAuthService: UserAuthServiceService,
    private router:Router) { }

  ngOnInit(): void {
  }
public LoginUser(){
    console.log(this.authRequest);
    this.service.generateToken(this.authRequest).subscribe(data=>{
    console.log(data.jwtToken)
    console.log(data.user.role[0].roleName);
    this.userAuthService.setRoles(data.user.role[0].roleName);
    this.userAuthService.setToken(data.jwtToken);
    const role = data.user.role[0].roleName;
    console.log(role);
    if(role == 'Admin')
    {
      this.router.navigate(['home']);
      console.log("Admin Login Admin");
    }
    else if(role == 'User')
    {
      console.log("user Login User");
    }
    else{
      console.log('Invalid');
    }
  });
}
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtClientService } from 'src/app/MyService/jwt-client.service';
import { UserAuthServiceService } from 'src/app/MyService/user-auth-service.service';

@Component({
  selector: 'app-stadium-header',
  templateUrl: './stadium-header.component.html',
  styleUrls: ['./stadium-header.component.css']
})
export class StadiumHeaderComponent implements OnInit {

  constructor(private userAuthService: UserAuthServiceService,
    public service:JwtClientService,
    private router:Router) { }

  ngOnInit(): void {
  }
  public isLoggedin(){
    return this.userAuthService.isLoggedIn();
  }
  public Logout(){
    this.userAuthService.clear();
    this.router.navigate(['/home'])
  }
}
